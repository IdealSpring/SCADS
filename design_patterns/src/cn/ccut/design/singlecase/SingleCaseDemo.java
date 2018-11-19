package cn.ccut.design.singlecase;

/**
 * 测试代码
 */
public class SingleCaseDemo {
    public static void main(String[] args) {
        // 懒汉式单例类
        SingleCaseLazy singleCaseLazy = SingleCaseLazy.getInstance();
        singleCaseLazy.description();

        // 饿汉式单例类
        SingleCaseHungry singleCaseHungry = SingleCaseHungry.getInstance();
        singleCaseHungry.description();
    }
}
