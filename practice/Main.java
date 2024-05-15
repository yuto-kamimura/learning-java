package practice;

public class Main {
    public static void main(String args[]) {
        // CommandScaner scanner = new CommandScaner();
        // int command = scanner.ScanCommandNumber();
        // System.out.println(command);
        Player player = new Player();
        Enemy enemy = new Enemy();
        player.attack(enemy);
        
        // enemy.attack(10);
    
        /* 作成条件 */
        /*
            コマンドラインからコマンドを入力し、プレイヤーがエネミーと戦うプログラム。
            処理の正常終了条件は以下
                １．プレイヤーかエネミーのどちらかのhpが0になる
                ２．プレイヤーがエネミーから逃げるのに成功
            また、以下のクラスを作成すること
                ・Playerクラス
                ・Enemyクラス
         */ 

    }
}
class Player{
    private int hp;
    private int attack = 10;
    void attack(Enemy enemy){
        enemy.hp = enemy.hp - attack;  // point
        if(enemy.hp <= 0){  // point
            System.out.println("プレイヤーの勝利です");
        }

    }

    // void escape()


}
class Enemy{
    int hp;
}
