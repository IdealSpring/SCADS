package cn.ccut.learnrecond.day_03.ccut_01;

public class MyThreadDemo {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.setFlag(false);
        System.out.println("已被赋值");
    }
}
