package cn.ccut.learnrecond.day_07;

public class DoubleCheckedLocking {
    // 没有volatile修饰，其他对象可能获取的时没有初始化的对象
    private static volatile DoubleCheckedLocking doubleCheckedLocking;

    // 私有化构造器，防止外界创建对象
    private DoubleCheckedLocking() {}

    public static DoubleCheckedLocking getInstance() {
        // 再次检查，防止已经存在对象，同步避免没有不必要的开销
        if (doubleCheckedLocking != null)
            return doubleCheckedLocking;

        // 使用class锁，而不是this；是因为在static修饰的方法中在类加载时才会被加载，此时只有Class类
        synchronized (DoubleCheckedLocking.class) {
            if (doubleCheckedLocking == null)
                // 类的创建过程：1.开辟空间，2.初始化对象，3.返回地址空间
                doubleCheckedLocking = new DoubleCheckedLocking();
        }

        return doubleCheckedLocking;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(DoubleCheckedLocking.getInstance());
        }).start();

        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
