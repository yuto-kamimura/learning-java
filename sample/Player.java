package sample;

public class Player {
    private int hp = 10;
    private int power = 20;
    private int deffence = 7;
    private int speed = 1;

    private String name;

    Player(String name) {
        this.name = name;
    }

    int action(Enemy enemy) {
        System.out.println("プレイヤーのターン");
        System.out.println("コマンドを入力してください。1:戦う, 2:逃げる");
        try {
            int command = CommandScaner.ScanCommandNumber();
            switch (command) {
                case Common.attackCommand:
                    this.attack(enemy);
                    return Common.battleContinue;
                case Common.escapeCommand:
                    if (this.escape(enemy)) {
                        return Common.battleContinue;
                    }
                    break;
                case Common.powerUpCommand:
                    return Common.battlePlayerPowerUp;
                default:
                    System.out.println("プレイヤーは何もしなかった!");
                    return Common.battleContinue;
            }
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        return Common.battleFinish;
    }

    void getDamage(int damage) {
        System.out.println(this.name + "は" + (damage - this.deffence) + "のダメージを受けた!");
        this.hp -= damage - this.deffence ;
    }

    void attack(Enemy enemy) {
        System.out.println(this.name + "の攻撃!");
        enemy.getDamage(this.power);
    }

    boolean isElemenated() {
        if (this.hp <= 0) {
            System.out.println(this.name + "は倒れた");
            return true;
        } else {
            printPlayerInfo();
            return false;
        }
    }

    int getSpeed() {
        return this.speed;
    }

    boolean escape(Enemy enemy) {
        if (Common.canEscape(this.speed - enemy.getSpeed())   ) {
            System.out.println(this.name + "は逃げることに成功した!");
            return true;
        } else {
            System.out.println(this.name + "は逃げられなかった!");
            return false;
        }
    }

    void printPlayerInfo(){
        System.out.println(name + ":" + "残りhp: " + hp);
    }

    String getName() {
        return this.name;
    }

    int getHP() {
        return this.hp;
    }
}
