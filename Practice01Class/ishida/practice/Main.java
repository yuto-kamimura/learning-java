package Practice01Class.ishida.practice;

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
        SuperHero hero = new SuperHero();

        for (int i = 0; player.getHp() > 0 && enemy.getHp() > 0; i++) {
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
                System.out.println("プレイヤーはエネミーに攻撃した" );
                player.attack(enemy);
                System.out.println("プレイヤーはエネミーに" + player.getPower() + "ダメージ与えた");
                System.out.println("エネミーの体力は残り" + enemy.getHp());
                if(enemy.getHp() <= 0){
                    System.out.println("プレイヤーの勝利です");
                    break;
                }
            }
            if(command == 3){
                System.out.println("プレイヤーは変身した!");
            }

            // エネミーの攻撃を実装する
            enemy.attack(player);
            System.out.println("エネミーはプレイヤーに攻撃した");
            System.out.println("エネミーはプレイヤーに" + enemy.getPower() + "ダメージ与えた");
            System.out.println("プレイヤーの体力は残り" + player.getHp());
            if (player.getHp() <= 0) {
                System.out.println("エネミーの勝利です");
                break;
            }
        }
    }
}

class Player {
    int hp = 100;
     int power = 10;
     int speed = 50;

    void attack(Enemy enemy) {
        enemy.updateHp(enemy.getHp() - power);
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
class SuperHero extends Player{
    private int magic = 10;
    // フィールド変数にpowerとsppedを追加する

    void attack(Enemy enemy) {
        enemy.updateHp(enemy.getHp() - super.getPower());
    }
    void magicAttack(Enemy enemy){
        enemy.updateHp(enemy.getHp() - getMagicPower());
    }
    int getMagicPower(){
        return magic;
    }
    SuperHero(){
        int speed = 100;
        int power = 30;
    }




}

class Enemy {
    private int hp = 100;
    private int power = 20;
    private int speed = 40;

    void attack(Player player) {
        player.updateHP(player.getHp() - power);
    }

    void updateHp(int newHp) {
        this.hp = newHp;
    }

    int getSpeed() {
        return speed;
    }

    int getHp() {
        return hp;
    }
    int getPower(){
        return power;
    }
}
