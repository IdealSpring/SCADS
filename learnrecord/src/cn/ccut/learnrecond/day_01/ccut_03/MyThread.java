package cn.ccut.learnrecond.day_01.ccut_03;

public class MyThread extends Thread {
    public MyThread() {}

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
