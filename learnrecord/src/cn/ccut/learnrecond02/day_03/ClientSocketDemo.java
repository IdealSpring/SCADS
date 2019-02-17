package cn.ccut.learnrecond02.day_03;

import java.io.*;
import java.net.Socket;

public class ClientSocketDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12345);

        BufferedReader reader = new BufferedReader(new FileReader("1.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

//        writer.write("over");
//        writer.flush();

//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String s = in.readLine();
//        System.out.println(s);

        reader.close();
        writer.close();
        socket.close();

//        ----------------------------------------------------------
//        Socket socket = new Socket("127.0.0.1", 12345);
//
//        OutputStream outputStream = socket.getOutputStream();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String line;
//        while ((line = reader.readLine()) != null && !"666".equals(line)) {
//            outputStream.write(line.getBytes());
//        }
//
//        reader.close();
//        outputStream.close();
//        outputStream.close();

//        ----------------------------------------------------------

//        Socket socket = new Socket("127.0.0.1", 12345);
//
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("你好TCP".getBytes());
//
//        InputStream inputStream = socket.getInputStream();
//        byte[] buff = new byte[1024];
//        int len = inputStream.read(buff);
//        System.out.println(new String(buff, 0, len));
//
//        // 关闭
//        inputStream.close();
//        outputStream.close();
//        socket.close();

//        // 创建客户端套接字
//        Socket socket = new Socket("127.0.0.1", 12345);
//
//        // 获取输出流
//        OutputStream outputStream = socket.getOutputStream();
//
//        // 写入数据
//        outputStream.write("你好 TCP".getBytes());
//
//        // 关闭流
//        outputStream.close();
//
//        // 关闭客户端
//        socket.close();
    }
}
