package cn.ccut.learnrecond.day_04;

public class YeildDemo {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "start");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "end");
        };

        new Thread(r, "小明").start();
        new Thread(r, "小李").start();
    }
}
