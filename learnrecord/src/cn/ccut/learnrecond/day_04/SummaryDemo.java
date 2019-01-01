package cn.ccut.learnrecond.day_04;

import java.util.Map;
import java.util.Set;

public class SummaryDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1.active Thread Count :" + Thread.activeCount());

        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("......");
        }, "自定义线程");
        System.out.println("t线程状态：" + t.getState());

        System.out.println("2.active Thread Count :" + Thread.activeCount());

        t.start();
        System.out.println("t线程状态：" + t.getState());

        System.out.println("3.active Thread Count :" + Thread.activeCount());
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        System.out.println("map count:" + allStackTraces.size());
        Set<Map.Entry<Thread, StackTraceElement[]>> entries = allStackTraces.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> threadEntry : entries) {
            Thread key = threadEntry.getKey();
            StackTraceElement[] value = threadEntry.getValue();
            System.out.println(key.getName());
            System.out.println(value);
        }

        while (t.getState() != Thread.State.TERMINATED) {
            Thread.sleep(1000);

            System.out.println("t线程状态：" + t.getState());
        }

        System.out.println("4.active Thread Count :" + Thread.activeCount());
        System.out.println("t线程状态：" + t.getState());
    }
}
