package cn.ccut.learnrecond.day_07;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSwapDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(5);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int left = atomicInteger.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + String.format(" 抢购1件 [剩余%s件]", left));
            }).start();
        }
    }
}
