package cn.ccut.learnrecond.day_11;

/**
 * 实现乐观锁的两种实现方式：
 * 1.版本号机制
 * 2.CAS 比较交换机制
 */
// 版本号机制乐观锁
class VersionNumber {
    int balance;
    volatile int versionNum;

    public VersionNumber(int balance, int versionNum) {
        this.balance = balance;
        this.versionNum = versionNum;
    }
}

// 线程
class MyThread implements Runnable {
    static VersionNumber versionNumber = new VersionNumber(100, 1);
    int consume;

    public MyThread(int consume) {
        this.consume = consume;
    }

    @Override
    public void run() {
        // 获取版本号
        int versionNum = versionNumber.versionNum;
        // 获取金额
        int balance = versionNumber.balance - consume;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 如果版本号相同，就跟新金额；否则失败
        if (versionNum == versionNumber.versionNum) {
            versionNumber.balance = balance;
            versionNumber.versionNum++;
            System.out.println(Thread.currentThread().getName() + "-->更新了金额(-" + consume + ")"
                    + "-->剩余：" + versionNumber.balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "更新失败");
        }

    }
}

public class OptimisticLockDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建使用版本号机制的乐观锁
        VersionNumber balanceByVN = new VersionNumber(100, 1);
        // 创建线程
        new Thread(new MyThread(50), "操作员A").start();
        new Thread(new MyThread(20), "操作员B").start();
    }
}
