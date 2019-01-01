package cn.ccut.learnrecond.day_07;

public class VolatileDemo {
    private static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        Thread.sleep(1000);
        num = 1;
        System.out.println("mian thread num:" + num);

        new Thread(() -> {
            System.out.println("other thread num:" + num);
        }).start();
    }
}
