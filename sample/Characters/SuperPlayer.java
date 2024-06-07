package sample.Characters;

import java.util.ArrayList;
import java.util.List;

import sample.Objects.CharacterParameter;
import sample.Objects.Magics.Fire;
import sample.Objects.Magics.Magic;
import sample.Objects.Magics.Thunder;
import sample.Utils.CommandScaner;
import sample.Utils.Common;

public class SuperPlayer extends Player {
    List<Magic> magics = new ArrayList<>();

    public SuperPlayer(String name, CharacterParameter params, int initMp) {
        super(name, params);
        this.params.mp = initMp; // 初期MP挿入
        super.switchSuperPlayerFlg(); // スーパープレイヤーになったことを伝達
        initSetMagics();
    }

    void initSetMagics() {
        magics.add(new Fire());
        magics.add(new Thunder());
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
        Magic m = selectMagic();

        int damage = m.getBaseDamage();
        super.params.mp -= m.getDecreaseMpAmount();

        enemy.getDamage(damage);
    }

    void physicalAttack(Enemy enemy) {
        enemy.getDamage(this.params.power * 2);
    }

    Magic selectMagic() {
        System.out.print("[");
        for (int i = 0; i < magics.size(); i++) {
            System.out.printf(i+1 + ". %s, ", magics.get(i).getMagicName());
        }
        System.out.println("]");
        int selected = 0;
        while (true) {
            int command = CommandScaner.ScanCommandNumber();
            if (command == 1 || command == 2) {
                selected = command;
                break;
            }
            System.out.println("もう一度選択してください。");
        }
        Magic m = this.magics.get(selected - 1);
        return m;
    }

}
