package cn.ccut.learnrecond.day_09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) {
        // 创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 提交可执行runnable或callable
        pool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        });
        pool.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        });

        pool.shutdown();
    }
}
