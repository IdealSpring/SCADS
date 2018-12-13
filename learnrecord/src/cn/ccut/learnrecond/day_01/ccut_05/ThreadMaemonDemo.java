package cn.ccut.learnrecond.day_01.ccut_05;

public class ThreadMaemonDemo {
    public static void main(String[] args) {
        ThreadMaemon t1 = new ThreadMaemon();
        ThreadMaemon t2 = new ThreadMaemon();

        t1.setName("关羽");
        t2.setName("张飞");

        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();

        Thread.currentThread().setName("刘备");
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
