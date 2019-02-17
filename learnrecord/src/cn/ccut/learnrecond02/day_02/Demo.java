package cn.ccut.learnrecond02.day_02;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        int i = 2;
        try {
            if (i != 2)
                throw new IOException();

            System.out.println("123");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
