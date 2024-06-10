package sample.Characters;

import sample.Objects.CharacterParameter;
import sample.Utils.Common;

public class Player {
    public CharacterParameter params;
    private String name;
    private boolean superPlayerFlg = false;

    public Player(String name, CharacterParameter params) {
        this.params = params;
        this.name = name;
    }

    void getDamage(int damage) {
        System.out.println(this.name + "は" + damage + "ダメージを受けた!");
        this.params.hp -= damage - this.params.deffence;
    }

    public void attack(Enemy enemy, int damage) {
        enemy.getDamage(damage);
    }

    public int getAttackDamage() {
        return this.params.power;
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

    public CharacterParameter getParams() {
        return this.params;
    }

    void updateParams(CharacterParameter params) {
        this.params = params;
    }

    void switchSuperPlayerFlg() {
        this.superPlayerFlg = true;
    }

    public boolean isSuperPlayer() {
        return this.superPlayerFlg;
    }
}
