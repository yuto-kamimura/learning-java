package Practice01Class.kamimura.sample;

public class Player {
    private int hp = 10;
    private int power = 20;
    private int deffence = 7;
    private int speed = 1;

    private String name;

    Player(String name) {
        this.name = name;
    }

    void printActionCommand() {
        System.out.println("コマンドを入力してください。1:戦う, 2:逃げる, 3:自己強化, それ以外:何もしない");
    }

    void getDamage(int damage) {
        System.out.println(this.name + "は" + (damage - this.deffence) + "のダメージを受けた!");
        this.hp -= damage - this.deffence;
    }

    void attack(Enemy enemy) {
        enemy.getDamage(this.power);
    }

    boolean isElemenated() {
        return this.hp <= 0;
    }

    boolean escape(Enemy enemy) {
        return Common.canEscape(this.speed - enemy.getSpeed());
    }

    void printPlayerInfo() {
        System.out.println(name + ":" + "残りhp: " + hp);
    }

    int getSpeed() {
        return this.speed;
    }

    int getPower() {
        return this.power;
    }

    String getName() {
        return this.name;
    }

    int getHP() {
        return this.hp;
    }
}
