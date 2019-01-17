package cn.ccut.learnrecond.day_12;

public class RingPhoneDecorator extends Decorator {
    public RingPhoneDecorator(Phone phone) {
        super(phone);
    }

    @Override
    public void call() {
        System.out.println("正在播放彩铃");
        super.call();
    }
}
