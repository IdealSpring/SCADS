package cn.ccut.learnrecond.day_11;

import java.io.File;
import java.io.FileFilter;

public class FileDemo {
    public static void main(String[] args) {
        //File srcFolder = new File("D:\\idealU\\deeplearning\\SCADS\\learnrecord\\src\\template");
        File srcFolder = new File("E:\\_Deep Learning Java\\01_JAVA基础视频（28天）");
        test5(srcFolder);
    }

    private static void test6(File srcFolder) {
        File[] filesArray = srcFolder.listFiles();

        for (File file : filesArray) {
            if (file.isDirectory()) {
                test6(file);
            } else {
                file.delete();
            }
        }

        srcFolder.delete();
    }

    private static void test5(File file) {
        File[] fileArray = file.listFiles();

        for (File f : fileArray) {
            if (f.isFile()) {
                if (f.getName().endsWith(".java"))
                    System.out.println(f.getAbsolutePath());
            } else {
                test5(f);
            }
        }
    }

    private static int test4(int i) {
        if (i == 1)
            return 1;
        else
            return i * test4(--i);
    }

    private static void test3(File file) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".jpg");
            }
        });

        for (File f : files) {
            System.out.println(f);
        }
    }

    private static void test2(File file) {
        File[] files = file.listFiles();

        if (files == null)
            return;

        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().endsWith(".jpg"))
                    System.out.println(f);
            } else {
                test2(f);
            }
        }
    }

    private static void test1() {
        File file = new File("C:\\");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-----------------");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }
}
