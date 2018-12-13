package cn.ccut.learnrecond.day_02.ccut_01;

public class GetThread implements Runnable {
    private Student student;

    public GetThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (student) {
                if (!student.flag) {
                    try {
                        student.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(student.name + "---" + student.age);

                student.flag = false;
                student.notify();
            }
        }
    }
}
