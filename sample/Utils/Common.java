package sample.Utils;

import java.util.Random;

public class Common {
    public static final int errorCommand = -9999;
    public static final int attackCommand = 1;
    public static final int escapeCommand = 2;
    public static final int powerUpCommand = 3;

    public static final int physicalAttack = 1;
    public static final int magicAttack = 2;

    public static final int battleFinish = 1;
    public static final int battleAttack = 2;
    public static final int battleEscape = 3;
    public static final int battlePlayerPowerUp = 4;
    public static final int battleNoAction = 5;

    public static boolean canEscape(int offset) {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // 1～10の範囲でランダムな整数を生成
        return randomNumber >= 5 - offset;
    }
}
