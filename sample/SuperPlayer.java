package sample;

public class SuperPlayer extends Player {
    private int mp = 10;
    private int magicPower = 15;

    SuperPlayer(String name) {
        super(name);
    }

    @Override
    int action(Enemy enemy) {
        System.out.println("コマンドを入力してください。1:戦う, 2:逃げる, それ以外:何もしない");
        try {
            int command = CommandScaner.ScanCommandNumber();
            switch (command) {
                case Common.attackCommand:
                    this.attack(enemy);
                    return Common.battleAttack;
                case Common.escapeCommand:
                    if (this.escape(enemy)) {
                        return Common.battleEscape;
                    }
                    break;
                default:
                    return Common.battleNoAction;
            }
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        return Common.battleFinish;
    }

    @Override
    void attack(Enemy enemy) throws NumberFormatException {
        System.out.println("1:物理攻撃, 2:魔法攻撃, それ以外:戻る");
        switch (CommandScaner.ScanCommandNumber()) {
            case Common.attackCommand:
                physicalAttack(enemy);
                break;
            case Common.magicAttack:
                magicAttack(enemy);
                break;
            default:
                action(enemy);
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
