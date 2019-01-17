package cn.ccut.learnrecond.day_12;

public class IPhone implements Phone{
    @Override
    public void call() {
        System.out.println("IPhone 正在拨号......");
    }
}
