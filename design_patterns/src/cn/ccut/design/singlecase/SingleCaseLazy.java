package cn.ccut.design.singlecase;

/**
 * 单例模式——懒汉式单例类
 */
public class SingleCaseLazy {
    // 存放实例对象
    private static SingleCaseLazy singleCaseLazy;

    // 私有化构造器，阻止被其他类new出来
    private SingleCaseLazy() { }

    // 外界通过此类获取本类对象
    public static SingleCaseLazy getInstance() {
        // 先判断实例是否存在，不存在再加锁处理
        if (singleCaseLazy == null) {
            // 在同一个时刻加了锁的那部分只有一个线程可以进入
            synchronized (SingleCaseLazy.class) {
                // 防止多线程情况下，线程都到达锁上等待时，等待完成进入再次创建实例
                if (singleCaseLazy == null) {
                    // 创建实例
                    singleCaseLazy = new SingleCaseLazy();
                }
            }
        }

        // 返回实例
        return singleCaseLazy;
    }

    public void description() {
        System.out.println("SingleCaseLazy Class successful......");
    }
}
