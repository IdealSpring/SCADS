package cn.ccut.design.command;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new ConcreteCommand(new Receiver()));

        invoker.executeCommand();
    }
}
