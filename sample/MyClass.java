package sample;

public class MyClass {
    public static void main(String args[]) {
        CommandScaner scanner = new CommandScaner();

        Enemy enemy = new Enemy("ENEMY");
        Player player = new Player("PLAYER");

        loop: while (true) {
            System.out.println("プレイヤーのターン");
            System.out.println("コマンドを入力してください。1:戦う, 2:逃げる");
            int command = scanner.ScanCommandNumber();
            switch (command) {
                case Common.attackCommand:
                    player.attack(enemy);
                    break;
                case Common.escapeCommand:
                    if (player.escape(enemy)) {
                        break loop;
                    }
                    break;
                default:
                    System.out.println("プレイヤーは何もしなかった!");
                    break;
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
