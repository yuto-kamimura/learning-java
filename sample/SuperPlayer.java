package sample;

public class SuperPlayer extends Player {
    private int mp = 10;
    private int magicPower = 15;

    SuperPlayer(String name) {
        super(name);
    }

    void attack(Enemy enemy) throws NumberFormatException {
        System.out.println("1:物理攻撃, 2:魔法攻撃");
        switch (CommandScaner.ScanCommandNumber()) {
            case Common.attackCommand:
                physicalAttack(enemy);
                break;
            case Common.magicAttack:
                magicAttack(enemy);
                break;
            default:
                attack(enemy);
        }
        System.out.println(super.getName() + "の攻撃!");
    }

    void magicAttack(Enemy enemy) {
        mp -= 2;
        enemy.getDamage(magicPower);
    }

    void physicalAttack(Enemy enemy) {

    }

    void printPlayerInfo() {
        System.out.println(super.getName() + ":" + "残りhp: " + super.getHP() + "残りmp: " + this.mp);
    }

}
