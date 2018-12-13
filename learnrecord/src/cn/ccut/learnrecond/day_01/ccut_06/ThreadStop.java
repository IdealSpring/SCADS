package cn.ccut.learnrecond.day_01.ccut_06;

import java.util.Date;

public class ThreadStop extends Thread {
    @Override
    public void run() {
        System.out.println("开始：" + new Date());

        try {
            sleep(1000 * 10);
        } catch (InterruptedException e) {
            System.out.println("程序抛出异常，被终止了");
        }

        System.out.println("结束：" + new Date());
    }
}
