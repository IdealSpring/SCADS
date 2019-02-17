package cn.ccut.learnrecond02.day_03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket accept = serverSocket.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("2.txt"));

        String line;
        while ((line = reader.readLine()) != null && !"over".equals(line)) {
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
//        out.write("接收成功");
//        out.flush();

        reader.close();
        writer.close();
        accept.close();

//        -------------------------------------------------------------------

//        ServerSocket serverSocket = new ServerSocket(12345);
//        Socket accept = serverSocket.accept();
//
//        InputStream inputStream = accept.getInputStream();
//        byte[] buff = new byte[1024];
//        int len;
//        while ((len = inputStream.read(buff)) != -1) {
//            System.out.println(new String(buff, 0, len));
//        }

//        -------------------------------------------------------------------

//        ServerSocket serverSocket = new ServerSocket(12345);
//        Socket accept = serverSocket.accept();
//
//        // 读取数据
//        InputStream inputStream = accept.getInputStream();
//        byte[] buff = new byte[1024];
//        int len = inputStream.read(buff);
//        System.out.println(new String(buff, 0, len));
//
//        // 反馈
//        OutputStream outputStream = accept.getOutputStream();
//        outputStream.write("服务器接收成功".getBytes());
//
//        // 关闭输入输出流
//        inputStream.close();
//        outputStream.close();
//        accept.close();

//        // 创建服务端套接字
//        ServerSocket serverSocket = new ServerSocket(12345);
//
//        // 接收连接请求
//        Socket accept = serverSocket.accept();
//
//        // 获取输入流
//        InputStream inputStream = accept.getInputStream();
//
//        // 读取数据
//        byte[] buff = new byte[1024];
//        int len = inputStream.read(buff);
//        System.out.println(new String(buff, 0, len));
//
//        // 关闭连接的socket
//        accept.close();
    }
}
