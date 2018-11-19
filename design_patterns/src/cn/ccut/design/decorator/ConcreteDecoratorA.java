package cn.ccut.design.decorator;

public class ConcreteDecoratorA extends Decorator {
    @Override
    public void speak() {
        super.speak();
        seconedSpeak();
        System.out.println("ConcreteDecoratorA...Over");
    }

    private void seconedSpeak() {
        System.out.println("它蹉跎了所有");
    }
}
