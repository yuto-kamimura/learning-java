package practice;

public class Main {
    public static void main(String args[]) {
        // CommandScaner scanner = new CommandScaner();
        // int command = scanner.ScanCommandNumber();
        // System.out.println(command);
        Player player = new Player();
        Enemy enemy = new Enemy();
        player.attack(enemy);
        enemy.attack(player);
        for (int i = 0; player.getHp() <= 0 || enemy.getHP() <= 0; i++) {
        if (enemy.getHP() <= 0) { // point
            System.out.println("プレイヤーの勝利です");
        }
        }
        // enemy.attack(10);

        /* 作成条件 */
        /*
         * コマンドラインからコマンドを入力し、プレイヤーがエネミーと戦うプログラム。
         * 処理の正常終了条件は以下
         * １．プレイヤーかエネミーのどちらかのhpが0になる
         * ２．プレイヤーがエネミーから逃げるのに成功
         * また、以下のクラスを作成すること
         * ・Playerクラス
         * ・Enemyクラス
         */

    }
}

class Player {
    private int hp = 100;
    private int power = 10;

    void attack(Enemy enemy) {
        enemy.updateHP(enemy.getHP() - power);
    }

    int getHp() {
        return hp;
    }

    // void escape()

}

class Enemy {
    private int hp = 100;
    private int power = 10;

    void attack(Player player) {
        player.updateHP(player.getHP() - power);
    }

    void updateHP(int newHp) {
        this.hp = newHp;
    }

    int getHP() {
        return hp;
    }
}
