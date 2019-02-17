package cn.ccut.learnrecond02.day_04;

import java.io.*;
import java.net.Socket;

public class UploadClient {
    public static void main(String[] args) throws IOException {
        // 创建客户端套接字
        Socket clientSocket = new Socket("127.0.0.1", 12345);

        // 向服务端写数据
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
        BufferedInputStream readFile = new BufferedInputStream(new FileInputStream("1.txt"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = readFile.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
            bufferedOutputStream.flush();
        }

        // 上传完毕
        clientSocket.shutdownOutput();

        // 接收反馈
        BufferedInputStream bufferedInputStream = new BufferedInputStream(clientSocket.getInputStream());
        len = bufferedInputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));

        // 关闭和释放资源
        readFile.close();
        clientSocket.close();
    }
}
