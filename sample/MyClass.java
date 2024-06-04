package sample;

public class MyClass {
    public static void main(String args[]) {
        Enemy enemy = new Enemy("ENEMY");
        Player player = new Player("PLAYER");
        battle(player, enemy);
    }

    static void battle(Player player, Enemy enemy) {
        while (true) {
            System.out.println("\nプレイヤーのターン");
            int action = player.action(enemy);

            switch (action) {
                case Common.battlePlayerPowerUp:
                    player = new SuperPlayer("スーパープレイヤー");
                    break;
                case Common.battleAttack:
                    System.out.println(player.getName() + "の攻撃!");
                    break;
                case Common.battleEscape:
                    System.out.println("変身!!");
                    System.out.println("プレイヤーはスーパープレイヤーとなった");
                    break;
                case Common.battleNoAction:
                    break;
                case Common.battleFinish:
                    break;

                default:
                    break;
            }

            if (enemy.isElemenated()) {
                break;
            }

            Time.timeSleep(1000);
            System.out.println("\n敵のターン");
            enemy.attack(player);
            if (player.isElemenated()) {
                break;
            }
            Time.timeSleep(1000);
        }
        System.out.println("戦闘が終了した。");
    }
}
