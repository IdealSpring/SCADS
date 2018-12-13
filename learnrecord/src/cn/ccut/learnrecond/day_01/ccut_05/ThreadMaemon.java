package cn.ccut.learnrecond.day_01.ccut_05;

public class ThreadMaemon extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}