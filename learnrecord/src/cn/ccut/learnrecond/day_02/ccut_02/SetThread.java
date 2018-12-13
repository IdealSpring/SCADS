package cn.ccut.learnrecond.day_02.ccut_02;

public class SetThread implements Runnable {
    private Student student;
    private int i = 0;

    public SetThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            if (i % 2 == 0) {
                student.set("小明", 22);
            } else {
                student.set("丽萍", 6);
            }
            i++;
        }
    }
}
