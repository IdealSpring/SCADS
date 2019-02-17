package cn.ccut.learnrecond02.day_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerThread implements Runnable{
    private DatagramSocket serverSocket;

    public ServerThread(DatagramSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        // 创建数据报包
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        while (true) {
            try {
                // 接收数据
                serverSocket.receive(datagramPacket);

                // 解析数据
                String ip = datagramPacket.getAddress().getHostAddress();
                String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

                System.out.println(ip + " send : " + str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
