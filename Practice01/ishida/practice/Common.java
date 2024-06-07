
package Practice01.ishida.practice;
import java.util.Random;

public class Common {
    static final int errorCommand = -9999;
    static final int attackCommand = 1;
    static final int escapeCommand = 2;

    static boolean isOK(int offset) {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1; // 1～10の範囲でランダムな整数を生成
        System.out.println("Generated number: " + randomNumber);
        return randomNumber >= 5 + offset;
    }

}
