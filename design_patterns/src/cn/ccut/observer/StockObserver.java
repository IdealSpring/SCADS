package cn.ccut.observer;

/**
 * ConcreteObserver
 * @author zhipeng_Tong
 */
public class StockObserver implements Observer {
    private String name;    // 名称
    private String observerState;   // 状态
    private Boss subject;    // 通知者

    public StockObserver(String name, Boss subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println(String.format("%s - %s 关闭股票软件，继续工作。", observerState, name));
    }
}
