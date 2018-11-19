package cn.ccut.design.factorymethod;

public class Client {
    public static void main(String[] args) {
        Factory factory = new AddFactory();
        Operation operation = factory.createOperation();
        double result = operation.getResult(2, 2);
        System.out.println("add operation result: " + result);

        Factory factory1 = new SubtractionFactory();
        Operation operation1 = factory1.createOperation();
        double result1 = operation1.getResult(9, 3);
        System.out.println("substractionFactory operation result: " + result1);
    }
}
