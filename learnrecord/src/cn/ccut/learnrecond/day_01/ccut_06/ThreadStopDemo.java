package cn.ccut.learnrecond.day_01.ccut_06;

public class ThreadStopDemo {
    public static void main(String[] args) {
        ThreadStop t = new ThreadStop();

         t.start();

        try {
            Thread.sleep(1000 * 3);
//            t.stop();
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
