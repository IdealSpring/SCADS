package cn.ccut.learnrecond.day_13;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BlockNIODemo {
    @Test
    public void server() throws IOException {
        // 1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2.监听端口
        serverSocketChannel.bind(new InetSocketAddress(8989));

        // 3.获取客户端连接通道
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 4.将客户端的数据写入本地
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileChannel outChannel = FileChannel.open(Paths.get("dest.jpg"), StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        // 5.关闭
        serverSocketChannel.close();
        socketChannel.close();
        outChannel.close();
    }

    @Test
    public void client() throws IOException {
        // 1.获取连接
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));

        // 2.读取本地文件，发总到服务器
        FileChannel fileChannel = FileChannel.open(Paths.get("src.jpg"), StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        // 3. 关闭
        socketChannel.close();
        fileChannel.close();

    }
}
