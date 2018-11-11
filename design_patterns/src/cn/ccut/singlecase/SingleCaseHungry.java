package cn.ccut.singlecase;

/**
 * 单例模式——饿汉式单例类
 */
public class SingleCaseHungry {
    // 存放实例对象
    private static SingleCaseHungry singleCaseHungry = new SingleCaseHungry();

    // 私有化构造器
    private SingleCaseHungry() { }

    // 外界通过此类获取本类对象
    public static SingleCaseHungry getInstance() {
        // 返回实例
        return singleCaseHungry;
    }

    public void description() {
        System.out.println("SingleCaseHungry Class successful......");
    }
}
