package cn.ccut.learnrecond.day_13;

import org.junit.Test;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public class ChannelDemo {
    // 6.编码与解码
    @Test
    public void test07() throws Exception {
        Charset charset = Charset.forName("UTF-8");
        // 获取编码器
        CharsetEncoder encode = charset.newEncoder();
        // 获取解码器
        CharsetDecoder decode = charset.newDecoder();

        CharBuffer buffer = CharBuffer.allocate(1024);
        buffer.put("淡然 人生最美的风景！");
        buffer.flip();

        // 编码
        ByteBuffer byteBuffer = encode.encode(buffer);
        byte[] bys = new byte[byteBuffer.limit()];
        byteBuffer.get(bys);
        System.out.println(Arrays.toString(bys));

        // 解码
        byteBuffer.flip();
        CharBuffer decode1 = decode.decode(byteBuffer);
        System.out.println(decode1);

    }

    // Test
    @Test
    public void test06() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("中国".getBytes());
        buffer.flip();
        byte[] bys = new byte[buffer.limit()];
        buffer.get(bys);
        System.out.println(new String(bys));
        System.out.println(buffer.toString());
    }

    // 5.字符集
    @Test
    public void test05() {
        SortedMap<String, Charset> map = Charset.availableCharsets();

        Set<Entry<String, Charset>> entries = map.entrySet();
        for (Entry<String, Charset> KeyValue : entries)
            System.out.println(KeyValue.getKey() + "=" + KeyValue.getValue());

    }

    // 4.分散和聚集
    @Test
    public void test04() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        FileChannel inChannel = randomAccessFile.getChannel();
        // 分散
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024 * 100);
        ByteBuffer[] dst = {buffer1, buffer2};

        inChannel.read(dst);

        for (ByteBuffer buffer : dst) {
            buffer.flip();
            byte[] bys = buffer.array();
            System.out.println(new String(bys));
            System.out.println("-----------------------------------------------");
        }

        // 聚集写入
        RandomAccessFile out = new RandomAccessFile("2.txt", "rw");
        FileChannel outChannel = out.getChannel();
        outChannel.write(dst);
    }

    // 3.使用通道之间数据传输(内存映射文件)
    @Test
    public void test03() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E://nio.zip"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E://2.zip"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        inChannel.transferTo(0, inChannel.size(), outChannel);

        inChannel.close();
        outChannel.close();
    }

    // 2.使用直接缓冲区完成文件复制(内存映射文件)
    @Test
    public void test02() throws IOException {
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("E:\\nio.zip"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\2.zip"), StandardOpenOption.READ,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        MappedByteBuffer inBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inBuffer.limit()];
        inBuffer.get(dst);
        outBuffer.put(dst);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - start));
    }

    // 1.使用通道进行文件复制(非直接缓冲区)
    @Test
    public void test01() {
        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fileInputStream = new FileInputStream("E:\\nio.zip");
            fileOutputStream = new FileOutputStream("E:\\1.zip");

            inChannel = fileInputStream.getChannel();
            outChannel = fileOutputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 写入数据
            while (inChannel.read(buffer) != -1) {
                // 切换成读取模式
                buffer.flip();
                // 写入数据
                outChannel.write(buffer);
                // 清空缓冲区
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (inChannel != null) {
                                try {
                                    inChannel.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } finally {
                                    if (outChannel != null) {
                                        try {
                                            outChannel.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - start));
    }
}
