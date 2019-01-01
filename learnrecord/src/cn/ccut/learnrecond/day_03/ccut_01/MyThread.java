package cn.ccut.learnrecond.day_03.ccut_01;

public class MyThread extends Thread {
    private volatile boolean flag = true;
    private int count = 0;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("进入run方法...");
        while (flag == true) {
            count++;
            System.out.println(count + " : flag=" + flag);
        }

        System.out.println(count + " : flag=" + flag);
        System.out.println("线程终止");
    }
}
