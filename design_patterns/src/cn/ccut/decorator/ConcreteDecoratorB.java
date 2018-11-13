package cn.ccut.decorator;

public class ConcreteDecoratorB extends Decorator {
    @Override
    public void speak() {
        super.speak();
        System.out.println("他向我...");
        System.out.println("ConcreteDecoratorB...Over");
    }
}
