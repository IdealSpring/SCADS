package cn.ccut.learnrecond.day_01.ccut_05;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin t1 = new ThreadJoin();
        ThreadJoin t2 = new ThreadJoin();
        ThreadJoin t3 = new ThreadJoin();

        t1.setName("李渊");
        t2.setName("李世民");
        t3.setName("李元霸");

        t1.start();
        t1.join();

        t2.start();
        t3.start();
    }
}
