package practice;

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

public class Main {
    public static void main(String args[]) {
        Player player = new Player();
        Enemy enemy = new Enemy();

        for (int i = 0; player.getHp() > 0 || enemy.getHP() > 0; i++) {
            int command = CommandScaner.ScanCommandNumber();

            if (command == 2) {
                if (player.getSpeed() > enemy.getSpeed()) {
                    System.out.println("プレイヤーは逃げ出した");
                    break;
                } else {
                    System.out.println("プレイヤーは逃げ出すことができなかった");
                }
            }

            if (command == 1) {
                // 以下にプレイヤーが攻撃する処理を書く

                System.out.println("プレイヤーはエネミーに攻撃した" );
                player.attack(enemy);
                System.out.println("プレイヤーはエネミーに" + player.getPower() + "ダメージ与えた");
                System.out.println("エネミーの体力は残り" + enemy.getHP());
            }
            // 5/23 command == 1（戦う）処理を作成する

        }

        if (enemy.getHP() <= 0) { // point
            System.out.println("プレイヤーの勝利です");
        } else if (player.getHp() <= 0) {
            System.out.println("エネミーの勝利です");
        }

    }
}

class Player {
    private int hp = 100;
    private int power = 10;
    private int speed = 50;

    void attack(Enemy enemy) {
        enemy.updateHP(enemy.getHP() - power);
    }

    void updateHP(int newHp) {
        this.hp = newHp;
    }

    int getSpeed() {
        return speed;
    }

    int getHp() {
        return hp;
    }

    int getPower() {
        return power;
    }

    // void escape()

}

class Enemy {
    private int hp = 100;
    private int power = 10;
    private int speed = 40;

    void attack(Player player) {
        player.updateHP(player.getHp() - power);
    }

    void updateHP(int newHp) {
        this.hp = newHp;
    }

    int getSpeed() {
        return speed;
    }

    int getHP() {
        return hp;
    }
}
