package cn.ccut.strategy;

public class Client {
    public static void main(String[] args) {
        Context context;
        context = new Context(new StrategyImplA());
        context.method();

        context = new Context(new StrategyImplB());
        context.method();

        context = new Context(new StrategyImplC());
        context.method();
    }
}
