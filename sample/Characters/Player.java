package sample.Characters;

import sample.Objects.CharacterParameter;
import sample.Utils.Common;

public class Player {
    public CharacterParameter params;
    private String name;

    public Player(String name, CharacterParameter params) {
        this.params = params;
        this.name = name;
    }

    void getDamage(int damage) {
        this.params.hp -= damage - this.params.deffence;
    }

    public void attack(Enemy enemy) {
        enemy.getDamage(this.params.power);
    }

    public boolean isElemenated() {
        return this.params.hp <= 0;
    }

    public boolean escape(Enemy enemy) {
        return Common.canEscape(this.params.speed - enemy.getSpeed());
    }

    public String getName() {
        return this.name;
    }

    CharacterParameter getParams() {
        return this.params;
    }

    int getSpeed() {
        return this.params.speed;
    }

    int getPower() {
        return this.params.power;
    }

    int getHP() {
        return this.params.hp;
    }

    void updateParams(CharacterParameter params) {
        this.params = params;
    }
}
