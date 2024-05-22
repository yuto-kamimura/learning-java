package sample;

public class MyClass {
    public static void main(String args[]) {
        Enemy enemy = new Enemy("ENEMY");
        Player player = new Player("PLAYER");
        battle(player, enemy);
    }

    static void battle(Player player, Enemy enemy) {
        while (true) {
            int action = player.action(enemy);
            if (action == Common.battlePlayerPowerUP) {
                player = new SuperPlayer("スーパープレイヤー");
            }

            
            if (enemy.isElemenated()) {
                break;
            }

            Time.timeSleep(1000);
            System.out.println("敵のターン");
            enemy.attack(player);
            if (player.isElemenated()) {
                break;
            }
            Time.timeSleep(1000);
        }
        System.out.println("戦闘が終了した。");
    }
}
