package cn.ccut.learnrecond.day_04;

public class LambdaDemo implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("InterruptedException 异常");
        }

        System.out.println("Run 结束");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new LambdaDemo());
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
