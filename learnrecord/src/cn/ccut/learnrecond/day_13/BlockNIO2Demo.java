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

public class BlockNIO2Demo {
    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8989));

        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileChannel outChannel = FileChannel.open(Paths.get("dest.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        // 向客户端反馈
        byteBuffer.put("服务端已经接收到".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        serverSocketChannel.close();
        socketChannel.close();
        outChannel.close();
    }

    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));
        FileChannel inChannel = FileChannel.open(Paths.get("src.jpg"), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        socketChannel.shutdownOutput();

        // 接受反馈
        int len;
        while ((len = socketChannel.read(buffer)) != -1) {
            System.out.println(new String(buffer.array(), 0, len));
        }

        socketChannel.close();
        inChannel.close();
    }
}
