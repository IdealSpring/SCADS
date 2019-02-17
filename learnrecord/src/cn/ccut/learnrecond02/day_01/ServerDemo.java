package cn.ccut.learnrecond02.day_01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建服务端套接字
        DatagramSocket datagramSocket = new DatagramSocket(12345);

        // 2.创建接收报包
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        while (true) {
            // 3.接收数据报包
            datagramSocket.receive(datagramPacket);

            // 4.解析数据
            String ip = datagramPacket.getAddress().getHostAddress();
            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(ip + " send: " + str);
        }

        // 5.释放资源
//        datagramSocket.close();
    }
}
