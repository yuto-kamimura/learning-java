package sample.Characters;

import sample.Objects.CharacterParameter;
import sample.Utils.CommandScaner;
import sample.Utils.Common;

public class SuperPlayer extends Player {

    public SuperPlayer(String name, CharacterParameter params) {
        super(name, params);
    }

    void printAttackCommand() {
        System.out.println("1:物理攻撃, 2:魔法攻撃, それ以外:何もしない");
    }

    @Override
    public void attack(Enemy enemy) throws NumberFormatException {
        printAttackCommand();
        switch (CommandScaner.ScanCommandNumber()) {
            case Common.attackCommand:
                physicalAttack(enemy);
                break;
            case Common.magicAttack:
                magicAttack(enemy);
                break;
            default:
                break;
        }
    }

    void magicAttack(Enemy enemy) {
        super.params.mp -= 2;
        enemy.getDamage(super.params.mp * 10);
    }

    void physicalAttack(Enemy enemy) {
        enemy.getDamage(super.getPower());
    }

}
