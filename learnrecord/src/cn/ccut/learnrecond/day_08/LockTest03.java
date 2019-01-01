package cn.ccut.learnrecond.day_08;

import java.util.concurrent.locks.ReentrantLock;

// 可重入锁：锁可以连续使用
class ReLock {
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

public class LockTest03 {
    private ReentrantLock lock = new ReentrantLock();

    public void a() throws InterruptedException {
        System.out.println("a method before : " + lock.getHoldCount());
        lock.lock();
        System.out.println("a method in : " + lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println("a method after : " + lock.getHoldCount());
    }

    private void doSomething() throws InterruptedException {
        System.out.println("doSomething method before : " + lock.getHoldCount());
        lock.lock();
        System.out.println("doSomething method in : " + lock.getHoldCount());
        System.out.println("doSomething method .....");
        lock.unlock();
        System.out.println("doSomething method after : " + lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest03 lockTest03 = new LockTest03();
        lockTest03.a();
    }
}
