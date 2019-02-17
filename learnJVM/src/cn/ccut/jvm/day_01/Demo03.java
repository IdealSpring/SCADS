package cn.ccut.jvm.day_01;

public class Demo03 {
    private Demo03 obj;

    public static void main(String[] args) {
        Demo03 d1 = new Demo03();
        Demo03 d2 = new Demo03();

        d1.obj = d2;
        d2.obj = d1;
    }
}
