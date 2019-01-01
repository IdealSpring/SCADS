package cn.ccut.learnrecond.day_08;

public class LockTest01 {
    public void test() {
        synchronized (this) {
            while (true) {

                synchronized (this) {
                    System.out.println("Reentrant Locking......");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LockTest01 lockTest01 = new LockTest01();
        lockTest01.test();
    }
}
