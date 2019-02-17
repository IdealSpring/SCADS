package cn.ccut.learnrecond02.day_04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器端套接字
        ServerSocket serverSocket = new ServerSocket(12345);

        // 建立连接
        Socket accept = serverSocket.accept();

        // 读写数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream writeFile = new BufferedOutputStream(
                new FileOutputStream("copy.txt"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            writeFile.write(bytes, 0, len);
            writeFile.flush();
        }

        // 发送反馈给客户端
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(accept.getOutputStream());
        bufferedOutputStream.write("接收成功".getBytes());
        bufferedOutputStream.flush();

        // 关闭和释放
        writeFile.close();
        accept.close();
    }
}
