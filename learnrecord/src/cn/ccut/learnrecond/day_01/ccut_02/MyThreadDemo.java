package cn.ccut.learnrecond.day_01.ccut_02;

public class MyThreadDemo {
    public static void main(String[] args) {
//        ThreadMaemon t1 = new ThreadMaemon();
//        ThreadMaemon t2 = new ThreadMaemon();

        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");

//        System.out.println(t1.getPriority());



//        t1.setName("t1");
//        t2.setName("t2");
        t1.start();
        t2.start();

//        System.out.println(ThreadJoinDemo.currentThread().getName());
    }
}
