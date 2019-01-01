package cn.ccut.learnrecond.day_08;

// 不可重入锁：锁不可以连续使用
class Lock {
    // 是否占用标记
    private boolean isLocking = false;

    // 使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLocking)
            wait();

        isLocking = true;
    }

    // 释放用锁
    public synchronized void unLock() {
        isLocking = false;
        notify();
    }
}

public class LockTest02 {
    private Lock lock = new Lock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("a method .....");
        doSomething();
        lock.unLock();
    }

    private void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println("doSomething method .....");
        lock.unLock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest02 lockTest02 = new LockTest02();
        lockTest02.a();
    }
}
