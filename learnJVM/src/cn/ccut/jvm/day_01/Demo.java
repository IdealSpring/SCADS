package cn.ccut.jvm.day_01;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(new Student());
        }
    }
}
