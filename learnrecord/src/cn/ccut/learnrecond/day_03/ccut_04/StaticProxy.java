package cn.ccut.learnrecond.day_03.ccut_04;

public class StaticProxy {
    public static void main(String[] args) {
        new ProxyMarry(new Person()).happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

class Person implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("Person结婚...");
    }
}

class ProxyMarry implements Marry {
    private Marry marry;

    public ProxyMarry(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void happyMarry() {
        System.out.println("结婚前...");
        marry.happyMarry();
        System.out.println("结婚后...");
    }
}