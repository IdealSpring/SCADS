package cn.ccut.learnrecond.day_01.ccut_03;

public class MyThreadPrioriy {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("东方不败");
        MyThread t2 = new MyThread("岳不群");
        MyThread t3 = new MyThread("林平之");

        t1.setPriority(10);
        t3.setPriority(1);

        t1.start();
        t2.start();
        t3.start();
    }
}
