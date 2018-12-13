package cn.ccut.learnrecond.day_01.ccut_07;

public class ThreadRunableDemo {
    public static void main(String[] args) {
        // 创建自定义对象
        ThreadRunable t = new ThreadRunable();

        Thread thread = new Thread(t, "刘德华");
        thread.start();
    }
}
