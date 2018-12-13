package cn.ccut.learnrecond.day_02.ccut_02;

public class GetThread implements Runnable {
    private Student student;
    private int i = 0;

    public GetThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            student.get();
        }
    }
}
