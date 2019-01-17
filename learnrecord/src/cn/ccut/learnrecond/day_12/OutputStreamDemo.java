package cn.ccut.learnrecond.day_12;

import java.io.*;
import java.util.Arrays;

public class OutputStreamDemo {
    public static void main(String[] args) throws Exception {
        test11();
    }

    private static void test11() {

    }

    private static void test10() throws Exception {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("file.txt"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("copy.txt"));

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1)
            outputStream.write(bytes, 0, len);

        inputStream.close();
        outputStream.close();
    }

    private static void test9() throws Exception {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file.txt"));

        bos.write("java".getBytes());

        bos.close();
    }

    private static void test8() throws Exception {
        FileInputStream inputStream = new FileInputStream("file.txt");
        FileOutputStream outputStream = new FileOutputStream("copy.txt");

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1)
            outputStream.write(bytes, 0, len);

        inputStream.close();
        outputStream.close();
    }

    private static void test7() throws Exception {
        FileInputStream inputStream = new FileInputStream("file.txt");

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bys)) != -1)
            System.out.println(new String(bys, 0, len));

        inputStream.close();
    }

    private static void test6() {
//        String s = "abcde";
        String s = "我爱中国";
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
    }

    private static void test5() throws Exception {
        FileInputStream inputStream = new FileInputStream("file.txt");
        FileOutputStream outputStream = new FileOutputStream("copy.txt");

        int by = 0;
        while ((by = inputStream.read()) != -1)
            outputStream.write(by);

        inputStream.close();
        outputStream.close();
    }

    private static void test4() throws Exception {
        FileInputStream inputStream = new FileInputStream("file.txt");

        int bytes = 0;
        while ((bytes = inputStream.read()) != -1)
            System.out.print((char)bytes);

        inputStream.close();
    }

    private static void test3() {
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream("file.txt");
            outputStream.write("Java".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void test2() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("file.txt", true);

        for (int i = 0; i < 10; i++) {
            outputStream.write(("hello + " + i).getBytes());
            outputStream.write("\r\n".getBytes());
        }

        outputStream.close();
    }

    private static void test1() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("file.txt");

        outputStream.write("Hello IO".getBytes());

        outputStream.close();
    }
}
