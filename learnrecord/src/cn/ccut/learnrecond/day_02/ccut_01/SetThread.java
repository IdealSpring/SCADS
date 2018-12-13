package cn.ccut.learnrecond.day_02.ccut_01;

public class SetThread implements Runnable {
    private Student student;
    private int x = 0;

    public SetThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (student) {
                if (student.flag) {
                    try {
                        student.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (x % 2 == 0) {
                    student.name = "小明";
                    student.age = 12;
                } else {
                    student.name = "熊大";
                    student.age = 6;
                }

                x++;

                // 修改表及
                student.flag = true;
                // 唤醒
                student.notify();
            }
        }

    }
}
