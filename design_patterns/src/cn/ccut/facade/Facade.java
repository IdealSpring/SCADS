package cn.ccut.facade;

/**
 * Facade
 * @author zhipeng_Tong
 */
public class Facade {
    private ServiceA serviceA;
    private ServiceB serviceB;
    private ServiceC serviceC;

    public Facade() {
        this.serviceA = new ServiceA();
        this.serviceB = new ServiceB();
        this.serviceC = new ServiceC();
    }

    public void methodA() {
        serviceA.method();
        serviceB.method();
    }

    public void methodB() {
        serviceB.method();
        serviceC.method();
    }

    public void methodC() {
        serviceA.method();
        serviceC.method();
    }
}
