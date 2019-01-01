package cn.ccut.learnrecond.day_10;

public class MyLock {
    // 是否占用标记
    private boolean isLocking = false;
    // 存放占用线程
    private Thread lockByThread;
    // 计数器
    private int holdCount;

    // 使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocking && lockByThread != lockByThread)
            wait();

        isLocking = true;
        holdCount++;
        lockByThread = t;
    }

    // 释放用锁
    public synchronized void unLock() {
        if (Thread.currentThread() == lockByThread) {
            holdCount--;

            if (holdCount == 0) {
                isLocking = false;
                notify();
                lockByThread = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}
