package cn.ccut.learnrecond.day_08;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class WriteThread implements Runnable {
    private PipedOutputStream pipedOutputStream;

    public WriteThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        System.out.println("Write data:");
        try {
            for (int i = 0; i < 40; i++) {
                String outData = i + "";

                pipedOutputStream.write(outData.getBytes());
                System.out.print(outData + " ");

            }
            pipedOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}

class ReadThread implements Runnable {
    private PipedInputStream pipedInputStream;

    public ReadThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        System.out.println("Read data:");
        byte[] byteArray = new byte[20];
        try {
            int readLength = 0;
            while ((readLength = pipedInputStream.read(byteArray)) != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData + " ");
            }
            System.out.println();
            pipedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class PipedDemo {
    public static void main(String[] args) throws Exception {
        // 创建输入输出管道
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        // 将两个管道相互连接
        pipedOutputStream.connect(pipedInputStream);

        // 创建输出管道线程
        new Thread(new WriteThread(pipedOutputStream)).start();

        // 睡眠
        Thread.sleep(2000);

        // 创建输入管道线程
        new Thread(new ReadThread(pipedInputStream)).start();
    }
}
