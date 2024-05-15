package sample;

public class Enemy {
    private int hp = 32;
    private int power = 10;
    private int deffence = 5;
    private int speed = 5;

    private String name;

    Enemy(String name) {
        this.name = name;
        System.out.println(this.name + "が現れた!");
    }

    void getDamage(int damage) {
        System.out.println(name + "は" + (damage - this.deffence) + "のダメージを受けた!");
        this.hp -= damage - this.deffence;
    }

    void attack(sample.Player player) {
        System.out.println(this.name + "の攻撃!");
        player.getDamage(this.power);
    }

    boolean isElemenated() {
        if (this.hp <= 0) {
            System.out.println(name + "は倒れた");
            return true;
        } else {
            System.out.println(name + "の残りHP:" + this.hp);
            return false;
        }
    }

    int getSpeed() {
        return this.speed;
    }

}
