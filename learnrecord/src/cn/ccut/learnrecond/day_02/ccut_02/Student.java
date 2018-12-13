package cn.ccut.learnrecond.day_02.ccut_02;

public class Student {
    private String name;
    private int age;
    private boolean flag;

    public synchronized void set(String name, int age) {
        // 如果有数据，就等待
        if (this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 设置数据
        this.name = name;
        this.age = age;

        // 修改标记
        this.flag = true;
        // 唤醒等待进程
        this.notify();
    }

    public synchronized void get(){
        // 没有就等待
        if (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.name + ":" + this.age);

        // 修改标记
        this.flag = false;
        this.notify();
    }
}
