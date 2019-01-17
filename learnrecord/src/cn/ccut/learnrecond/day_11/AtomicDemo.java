package cn.ccut.learnrecond.day_11;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(100);

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (; ; ) {
                int current = atomicInteger.get();
                int next = current + 1;
                if (atomicInteger.compareAndSet(current, next))
                    System.out.println(Thread.currentThread().getName() + "-->" + next);
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(runnable, "线程" + i).start();
        }
    }
}
