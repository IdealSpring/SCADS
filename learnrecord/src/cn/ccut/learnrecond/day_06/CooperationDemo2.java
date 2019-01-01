package cn.ccut.learnrecond.day_06;

class TV {
    // flag为true，代表观看
    // flag为false，代表表演
    protected boolean flag;
    protected String voice;

    // 演员表演
    public synchronized void play(String voice) {
        // 等待条件
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("表演了" + voice);
        this.voice = voice;

        // 唤醒
        this.notifyAll();
        // 修改标记
        this.flag = !this.flag;
    }

    public synchronized void watch() {
        // 等待条件
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观众收看-->" + this.voice);
        // 唤醒
        this.notifyAll();
        // 修改标记
        this.flag = !this.flag;
    }
}

class Player implements Runnable {
    protected TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            tv.play("大鱼吃小鱼");
        }
    }
}

class Watcher implements Runnable {
    protected TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            tv.watch();
        }
    }
}

public class CooperationDemo2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Thread(new Player(tv)).start();
        new Thread(new Watcher(tv)).start();
    }
}
