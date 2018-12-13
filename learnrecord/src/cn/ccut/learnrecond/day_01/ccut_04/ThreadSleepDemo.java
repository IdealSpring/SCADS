package cn.ccut.learnrecond.day_01.ccut_04;

public class ThreadSleepDemo {
    public static void main(String[] args) {
        ThreadSleep t1 = new ThreadSleep();
        ThreadSleep t2 = new ThreadSleep();

        t1.setName("熊大");
        t2.setName("熊二");

        t1.start();
        t2.start();
    }
}
