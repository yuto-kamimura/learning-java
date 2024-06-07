package sample.Characters;

import sample.Objects.CharacterParameter;

public class Enemy {
    public CharacterParameter params;

    private String name;

    public Enemy(String name, CharacterParameter params) {
        this.params = params;
        this.name = name;
    }

    void getDamage(int damage) {
        this.params.hp -= damage - this.params.deffence;
    }

    public void attack(Player player) {
        player.getDamage(this.params.power);
    }

    public boolean isElemenated() {
        return this.params.hp <= 0;
    }

    int getSpeed() {
        return this.params.speed;
    }

    public String getName() {
        return this.name;
    }

    CharacterParameter getParams() {
        return this.params;
    }

}
