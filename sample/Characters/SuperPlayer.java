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
    }

    @Override
    public void attack(Enemy enemy, int damage) throws NumberFormatException {
        enemy.getDamage(damage);
    }

    @Override
    public int getAttackDamage() {
        switch (CommandScaner.ScanCommandNumber()) {
            case Common.attackCommand:
                return physicalAttack();
            case Common.magicAttack:
                return magicAttack();
            default:
                return Common.battleNoAction;
        }
    }

    int magicAttack() {
        Magic m = selectMagic();

        int damage = m.getBaseDamage();
        super.params.mp -= m.getDecreaseMpAmount();

        return damage;
    }

    int physicalAttack() {
        return this.params.power * 2;
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
