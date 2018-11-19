package cn.ccut.design.decorator;

public class Client {
    public static void main(String[] args) {
        Speaker speaker = new Speaker();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

        concreteDecoratorA.setPerson(speaker);
        concreteDecoratorB.setPerson(concreteDecoratorA);
        concreteDecoratorB.speak();
    }
}
