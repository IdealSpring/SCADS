package cn.ccut.design.strategy;

/**
 * Context
 * @author zhipeng_Tong
 */
public class Context extends Strategy {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void method() {
        if (strategy != null)
            strategy.method();
    }
}
