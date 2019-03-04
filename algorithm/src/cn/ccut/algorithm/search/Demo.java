package cn.ccut.algorithm.search;

import org.junit.Test;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread - 1" + threadLocal.get());
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread - main" + threadLocal.get());

        new Thread(() -> {
//            threadLocal.set(2);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread - 2" + threadLocal.get());
        }).start();
    }

    public void test03() {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("availablePermits=" + semaphore.availablePermits());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        service.shutdown();
    }
    @Test
    public void test02() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            service.execute(() -> {
                System.out.println(String.format("正在执行第%s号程序...", finalI));
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("第%s号程序执行完毕...", finalI));
            });
        }
        service.shutdown();
    }

    @Test
    public void test01() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                System.out.println("run thread ..." + finalI + ", getCount=" + latch.getCount());
                latch.countDown();
                System.out.println("run thread ..." + finalI + " over");
            });
        }

        latch.await();
        System.out.println("Result count is " + latch.getCount());
        System.out.println("end main thread!");
        threadPool.shutdown();
    }
}
