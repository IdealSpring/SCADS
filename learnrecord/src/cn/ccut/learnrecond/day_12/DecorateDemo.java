package cn.ccut.learnrecond.day_12;

public class DecorateDemo {
    public static void main(String[] args) {
        Phone phone = new IPhone();
        phone.call();
        System.out.println("---------------");

        Decorator decorator = new RingPhoneDecorator(phone);
        decorator.call();

        System.out.println("--------------");
        decorator = new MusicPhoneDecorator(phone);
        decorator.call();

        System.out.println("-------------");
        decorator = new MusicPhoneDecorator(new RingPhoneDecorator(phone));
        decorator.call();
    }
}
