package cn.ccut.learnrecond.day_06;

import java.util.LinkedList;
import java.util.Queue;

// 产品
class Goods {
    protected int id;

    public Goods(int id) {
        this.id = id;
    }
}

// 生产者
class Producer implements Runnable {
    protected SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(String.format("生产 第%s个产品", i));
            container.push(new Goods(i));

        }
    }
}

// 消费者
class Consumer implements Runnable {
    protected SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(String.format("消费 第%s个产品", container.pop().id));
        }
    }
}

// 缓冲区
class SynContainer {
    protected Queue<Goods> queue = new LinkedList<>();
    protected final int MAX_SIZE = 10;

    // 生产
    public synchronized void push(Goods goods) {
        // 等待条件
        if (queue.size() >= MAX_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue.offer(goods);

        // 唤醒
        this.notifyAll();
    }

    // 消费
    public synchronized Goods pop() {
        // 等待条件
        if (queue.peek() == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 唤醒
        this.notifyAll();
        return queue.poll();
    }
}

public class CooperationDemo {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Thread(new Producer(synContainer)).start();
        new Thread(new Consumer(synContainer)).start();
    }
}
