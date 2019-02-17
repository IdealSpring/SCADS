package cn.ccut.learnrecond02.day_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建客户端套接字
        DatagramSocket datagramSocket = new DatagramSocket();

        // 2.创建发送数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        DatagramPacket datagramPacket;
        while ((line = reader.readLine()) != null && !line.equals("666")) {
            byte[] lineBytes = line.getBytes();

            // 3.创建数据报包，192.168.1.173
            datagramPacket = new DatagramPacket(lineBytes,
                    lineBytes.length, InetAddress.getByName("192.168.1.255"), 12345);

            // 4.发送数据
            datagramSocket.send(datagramPacket);
        }

        // 5.关闭资源
        datagramSocket.close();
    }
}
