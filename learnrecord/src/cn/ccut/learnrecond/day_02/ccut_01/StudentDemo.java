package cn.ccut.learnrecond.day_02.ccut_01;

public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student();

        Runnable setThread = new SetThread(student);
        Runnable getThread = new GetThread(student);
        Thread t1 = new Thread(setThread);
        Thread t2 = new Thread(getThread);

        t1.start();
        t2.start();
    }
}
