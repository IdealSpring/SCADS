package cn.ccut.proxy;

/**
 * Rroxy
 * @author zhipeng_Tong
 */
public class Proxy implements Subject {
    private Subject subject;

    public Proxy() {
        System.out.println("代理类 Proxy 被初始化...");
        this.subject = new RealSubject();
    }

    @Override
    public void active() {
        System.out.println("代理开始");
        subject.active();
        System.out.println("代理结束");
    }
}
