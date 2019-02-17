package cn.ccut.jvm.day_01;

public class Demo02 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println("test.......");
        test();
    }
}
