package Practice01Class.kamimura.sample;

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

    void attack(Player player) {
        player.getDamage(this.power);
    }

    boolean isElemenated() {
        return this.hp <= 0;
    }

    int getSpeed() {
        return this.speed;
    }

    String getName() {
        return this.name;
    }

    void printEnemyInfo() {
        System.out.println(name + "の残りHP:" + this.hp);
    }

}
