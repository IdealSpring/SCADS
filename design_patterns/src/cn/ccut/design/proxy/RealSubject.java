package cn.ccut.design.proxy;

/**
 * RealSubject
 * @author zhipeng_Tong
 */
public class RealSubject implements Subject {
    @Override
    public void active() {
        System.out.println("------------------------");
        System.out.println("被代理类 RealSubject....");
        System.out.println("------------------------");
    }
}
