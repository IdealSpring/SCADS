package cn.ccut.learnrecond.day_13;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class NonBlockingNIODemo {
    @Test
    public void server() throws IOException {
        // 1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 2.切换到非阻塞状态
        serverSocketChannel.configureBlocking(false);
        // 3.绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8989));
        // 4.获取选择器
        Selector selector = Selector.open();
        // 5.将serverSocketChannel通道注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6.轮序已经最备就绪的事件
        while (selector.select() > 0) {
            // 7.获取选择器上准备好的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                // 8.判断是什么事件准备就绪
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    // 9.读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                    socketChannel.close();
                } else if (selectionKey.isAcceptable()) {
                    // 10.若"接收就绪"，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    //11. 切换非阻塞模式
                    socketChannel.configureBlocking(false);

                    //12. 将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    // 11.读取数据
//                    FileChannel outChannel = FileChannel.open(Paths.get("dest.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//                    ByteBuffer buffer = ByteBuffer.allocate(1024);
//                    while (socketChannel.read(buffer) != -1) {
//                        buffer.flip();
//                        outChannel.write(buffer);
//                        buffer.clear();
//                    }
//                    socketChannel.close();
//                    outChannel.close();
                }

                iterator.remove();
            }
        }

        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        // 1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));
        // 2.切换到非阻塞模式
        socketChannel.configureBlocking(false);
        //3. 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //4. 发送数据给服务端
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            String str = scan.next();
            buf.put((new Date().toString() + "\n" + str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        // 4.关闭
        socketChannel.close();
    }
}
