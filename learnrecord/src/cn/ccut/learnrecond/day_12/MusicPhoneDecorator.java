package cn.ccut.learnrecond.day_12;

public class MusicPhoneDecorator extends Decorator {
    public MusicPhoneDecorator(Phone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("打完电话来一首Music");
    }
}
