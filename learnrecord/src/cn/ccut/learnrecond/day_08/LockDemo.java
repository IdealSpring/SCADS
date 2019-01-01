package cn.ccut.learnrecond.day_08;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockThread implements Runnable {
    private int num = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (num > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String.format("%s 正在出售第%d张票", Thread.currentThread().getName(), num--));
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockDemo {
    public static void main(String[] args) {
        LockThread thread = new LockThread();

        new Thread(thread, "窗口一").start();
        new Thread(thread, "窗口二").start();
        new Thread(thread, "窗口三").start();
    }
}
