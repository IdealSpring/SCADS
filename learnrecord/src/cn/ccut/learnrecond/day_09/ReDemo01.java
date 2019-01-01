package cn.ccut.learnrecond.day_09;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadLockThread implements Runnable {
    private ShareData shareData;
    private ReentrantReadWriteLock readWriteLock;

    public ReadLockThread(ShareData shareData, ReentrantReadWriteLock readWriteLock) {
        this.shareData = shareData;
        this.readWriteLock = readWriteLock;
    }

    public void read() {
        readWriteLock.readLock().lock();

        try {
            System.out.println("获得读锁 " + Thread.currentThread().getName() + "，读到内容为：" +
                    shareData.name + "-->时间：" + System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public void run() {
        read();
    }
}

class WriteLockThread implements Runnable {
    private ShareData shareData;
    private ReentrantReadWriteLock readWriteLock;

    public WriteLockThread(ShareData shareData, ReentrantReadWriteLock readWriteLock) {
        this.shareData = shareData;
        this.readWriteLock = readWriteLock;
    }

    public void write() {
        readWriteLock.writeLock().lock();

        try {
            System.out.println("获得写锁 " + Thread.currentThread().getName() +
                    "，写了内容为：写线程把我修改了" + "-->时间：" + System.currentTimeMillis());
            shareData.name = "写线程把我修改了";
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void run() {
        write();
    }
}

class ShareData {
    protected String name = "我是共享资源-Over";
}

public class ReDemo01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ShareData shareData = new ShareData();
        ReadLockThread readLockThread = new ReadLockThread(shareData, readWriteLock);
        WriteLockThread writeLockThread = new WriteLockThread(shareData, readWriteLock);
        new Thread(readLockThread).start();
        new Thread(writeLockThread).start();

    }
}
