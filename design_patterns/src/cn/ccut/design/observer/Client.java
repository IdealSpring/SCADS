package cn.ccut.design.observer;

public class Client {
    public static void main(String[] args) {
        Boss boss = new Boss();

        boss.add(new StockObserver("李传华", boss));
        boss.add(new StockObserver("周大海", boss));

        boss.setSubjectState("老板回来了");
        boss.toNotify();
    }
}
