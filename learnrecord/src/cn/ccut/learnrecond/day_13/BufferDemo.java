package cn.ccut.learnrecond.day_13;

import org.junit.Test;

import java.nio.ByteBuffer;

public class BufferDemo {
    @Test
    public void test2() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        System.out.println(buffer.isDirect());
    }

    @Test
    public void test1() {
        // 1.分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("-----------allocate(1024)------------");
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 1024
        System.out.println(buffer.capacity());  // 1024

        // 2.使用put方法添加数据
        buffer.put("abcde".getBytes());

        System.out.println("-----------put(\"abcde\".getBytes())------------");
        System.out.println(buffer.position());  // 5
        System.out.println(buffer.limit());     // 1024
        System.out.println(buffer.capacity());  // 1024

        // 3.使用flip方法后
        buffer.flip();
        System.out.println("-----------flip()------------");
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 5
        System.out.println(buffer.capacity());  // 1024

        // 4.使用get方法后
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println("-----------flip()------------");
        System.out.println(buffer.position());  // 5
        System.out.println(buffer.limit());     // 5
        System.out.println(buffer.capacity());  // 1024
        System.out.println(new String(dst, 0, buffer.limit()));

        // 5.使用rewind 重复读数据
        buffer.rewind();
        System.out.println("-----------rewind()------------");
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 5
        System.out.println(buffer.capacity());  // 1024

        // 6.清空缓冲区
        buffer.clear();
        System.out.println("-----------clear()------------");
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 1024
        System.out.println(buffer.capacity());  // 1024
    }
}
