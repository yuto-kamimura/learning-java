package sample;

public class Time {
    static void timeSleep(int millis) {
        try {
            // 1秒（1000ミリ秒）待つ
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // sleep中に割り込みが発生した場合の処理
            System.err.println("Thread was interrupted!");
        }

    }
}
