package sample;

public class Player {
    private int hp = 10;
    private int mp = 10;
    private int power = 20;
    private int deffence = 7;
    private int speed = 1;

    private String name;

    Player(String name) {
        this.name = name;
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
            System.out.println(this.name + "の残りHP:" + this.hp);
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
        System.out.println(name + ":" + "残りhp: " + hp + "残りmp: " + mp);
    }
}
