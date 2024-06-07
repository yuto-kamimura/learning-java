package Practice01Class.kamimura.sample;

public class MyClass {
    public static void main(String args[]) {
        Enemy enemy = new Enemy("ENEMY");
        Player player = new Player("PLAYER");
        battle(player, enemy);
    }

    static void battle(Player player, Enemy enemy) {
        loop: while (true) {
            System.out.println("\nプレイヤーのターン");
            player.printActionCommand();
            int command = CommandScaner.ScanCommandNumber();

            switch (command) {
                case Common.powerUpCommand:
                    System.out.println("変身!!");
                    System.out.println("プレイヤーはスーパープレイヤーとなった");
                    player = new SuperPlayer("スーパープレイヤー");
                    break;
                case Common.attackCommand:
                    System.out.println(player.getName() + "の攻撃!");
                    player.attack(enemy);
                    break;
                case Common.escapeCommand:
                    if (player.escape(enemy)) {
                        System.out.println(player.getName() + "は逃げることに成功した!");
                        break loop;
                    } else {
                        System.out.println(player.getName() + "は逃げきれなかった！");
                        break;
                    }
                default:
                    System.out.println("プレイヤーは何もしなかった!");
                    break;
            }

            if (enemy.isElemenated()) {
                System.out.println(enemy.getName() + "は倒れた");
                break;
            }

            Time.timeSleep(2000);

            System.out.println("\n敵のターン");
            System.out.println(enemy.getName() + "の攻撃!");
            enemy.attack(player);
            if (player.isElemenated()) {
                System.out.println(player.getName() + "は倒れた");
                break;
            } else {
                player.printPlayerInfo();
            }

            Time.timeSleep(2000);
        }
        System.out.println("戦闘が終了した。");
    }
}
