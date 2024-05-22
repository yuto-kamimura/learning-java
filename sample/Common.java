package sample;

import java.util.Random;

public class Common {
    static final int errorCommand = -9999;
    static final int attackCommand = 1;
    static final int escapeCommand = 2;
    static final int powerUpCommand = 3;

    static final int physicalAttack = 1;
    static final int magicAttack = 2;

    static final int battleFinish = 1;
    static final int battleContinue = 2;
    static final int battlePlayerPowerUP = 3;

    static boolean canEscape(int offset) {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // 1～10の範囲でランダムな整数を生成
        return randomNumber >= 5 - offset;
    }
}
