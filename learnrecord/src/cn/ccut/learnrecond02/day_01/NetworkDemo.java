package cn.ccut.learnrecond02.day_01;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class NetworkDemo {
    // UDP服务带
    @Test
    public void server() throws IOException {
        // 创建服务端套接字(指定端口)
        DatagramSocket datagramSocket = new DatagramSocket(12345);

        // 创建数据接收包
        byte[] buff = new byte[1024 * 64];
        int length = buff.length;
        DatagramPacket datagramPacket = new DatagramPacket(buff, length);

        // 接收数据报包
        datagramSocket.receive(datagramPacket);

        // 解析数据报包中的数据
        String hostName = datagramPacket.getAddress().getHostName();
        byte[] data = datagramPacket.getData();
        int packetLength = datagramPacket.getLength();
        System.out.println(hostName + "：" + new String(data, 0, packetLength));

        // 释放资源
        datagramSocket.close();
    }

    // UDP客户端
    @Test
    public void client() throws IOException {
        // 创建发送端套接字(Socket)对象
        DatagramSocket datagramSocket = new DatagramSocket();

        // 创建数据包
        byte[] buf = "我爱你大傻瓜".getBytes();
        int length = buf.length;
        InetAddress inetAddress = InetAddress.getByName("zhipeng_Tong");
        int port = 12345;
        DatagramPacket datagramPacket = new DatagramPacket(buf, length, inetAddress, port);

        // 发送数据报包
        datagramSocket.send(datagramPacket);

        // 释放资源
        datagramSocket.close();
    }


    @Test
    public void test01() throws UnknownHostException {
//        InetAddress inetAddress = InetAddress.getByName("zhipeng_Tong");
//        InetAddress inetAddress = InetAddress.getByName("172.30.149.65");
        InetAddress inetAddress = InetAddress.getByName("111.116.20.110");

        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
    }
}
