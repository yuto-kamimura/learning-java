package practice;

public class Time {
    void timeSleep(int time) {
        try {
            // 1秒（1000ミリ秒）待つ
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // sleep中に割り込みが発生した場合の処理
            System.err.println("Thread was interrupted!");
        }
        
    }
}
