package Practice01Class.kamimura.sample;

public class SuperPlayer extends Player {
    private int mp = 10;
    private int magicPower = 15;

    SuperPlayer(String name) {
        super(name);
    }

    @Override
    void printActionCommand() {
        System.out.println("コマンドを入力してください。1:戦う, 2:逃げる, それ以外:何もしない");
    }

    void printAttackCommand() {
        System.out.println("1:物理攻撃, 2:魔法攻撃, それ以外:何もしない");
    }

    @Override
    void attack(Enemy enemy) throws NumberFormatException {
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
        mp -= 2;
        enemy.getDamage(this.magicPower);
    }

    void physicalAttack(Enemy enemy) {
        enemy.getDamage(super.getPower());
    }

    @Override
    void printPlayerInfo() {
        System.out.println(super.getName() + ":" + "残りhp: " + super.getHP() + "残りmp: " + this.mp);
    }

    int getMagicPower() {
        return this.magicPower;
    }
}
