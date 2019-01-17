package cn.ccut.learnrecond.day_12;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class WriteAndReadDemo {
    public static void main(String[] args) throws Exception {
        test16();
    }

    private static void test16() throws IOException, URISyntaxException {
        Paths.get(new URI("d"));
        Properties properties = new Properties();

        // D:\idealU\deeplearning\SCADS\file.txt
//        properties.loadFromXML(WriteAndReadDemo.class.getResourceAsStream("D:\\idealU\\deeplearning\\SCADS\\file.txt"));

        properties.loadFromXML(new FileInputStream("file.txt"));
//        properties.load(new FileReader("file.txt"));

        System.out.println(properties);
    }

    private static void test15() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("张三", "12");
        properties.setProperty("李四", "27");
        properties.setProperty("王五", "9");

//        FileWriter writer = new FileWriter("file.txt");
//        properties.store(writer, "helloworld");
        FileOutputStream stream = new FileOutputStream("file.txt");
        properties.storeToXML(stream, "this is xml.");
        stream.close();
    }

    private static void test14() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("张三", "12");
        properties.setProperty("李四", "27");
        properties.setProperty("王五", "9");

        System.out.println(properties.getProperty("张三"));

    }

    private static void test13() throws IOException {
        Properties properties = new Properties();

        properties.put("小明", "中国");
        properties.put("多啦A梦", "日本");

//        System.out.println(properties);
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries)
            System.out.println(entry);
    }

    private static void test12() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("file.txt"));

        Object object = inputStream.readObject();

        inputStream.close();

        System.out.println(object);

    }

    private static void test11() throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("file.txt"));

        Student student = new Student("小明", 27);
        stream.writeObject(student);

        stream.close();
    }

    private static void test10() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入字符串：");
        String line = reader.readLine();
        System.out.println("你输入的值为：" + line);
    }

    private static void test09() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        writer.close();
        reader.close();
    }

    private void test08() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));

        char[] chs = new char[1024];
        int len;
        while ((len = reader.read(chs)) != -1)
            System.out.println(new String(chs, 0, len));

        reader.close();
    }

    private static void test07() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));

        writer.write("hello");
        writer.newLine();
        writer.write("world");
        writer.newLine();
        writer.write("java");

        writer.close();

    }

    private static void test06() throws IOException {
        FileReader reader = new FileReader("file.txt");
        FileWriter writer = new FileWriter("copy.txt");

        System.out.println(reader.getEncoding());
        System.out.println(writer.getEncoding());

        char[] chs = new char[1024];
        int len = 0;
        while ((len = reader.read(chs)) != -1)
            writer.write(chs, 0, len);

        writer.close();
        reader.close();
    }

    private static void test05() throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("file.txt"));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("copy.txt"));

        char[] chs = new char[1024];
        int len = 0;
        while ((len = reader.read(chs)) != -1)
            writer.write(chs, 0, len);

        writer.close();
        reader.close();
    }

    private static void test04() throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("file.txt"));

//        int ch = 0;
//        while ((ch = reader.read()) != -1)
//            System.out.print((char) ch);

        char[] chs = new char[1024];
        int len = 0;
        while ((len = reader.read(chs)) != -1) {
            System.out.println(new String(chs, 0, len));
        }


        reader.close();
    }

    private static void test03() throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("file.txt"));

//        writer.write(97);
//        writer.write('a');

        char[] chs = {'a', 'b', 'c'};
//        writer.write(chs);
//        writer.write(chs, 0, 2);

        String s = "我爱你中国";
//        writer.write(s);
        writer.write(s, 1, 2);

        writer.flush();
        writer.close();
    }

    private static void test02()  throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("file.txt"));

        int ch = 0;
        while ((ch = reader.read()) != -1)
            System.out.print((char) ch);

        reader.close();
    }

    private static void test01() throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("file.txt"));

        writer.write("中国");

        writer.close();
    }
}
