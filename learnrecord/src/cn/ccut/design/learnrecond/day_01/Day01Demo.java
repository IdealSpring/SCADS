package cn.ccut.design.learnrecond.day_01;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Day01Demo {
    /**
     * 交通工具接口
     */
    private interface Moveable {
        // 移动
        public abstract void move();

        // 输出信息
        public abstract void show();
    }

    /**
     * 交通工具抽象类
     */
    private abstract class AbstractMoveable implements Moveable {
        private String name = "";       // 交通工具名称
        private String clas = "";       // 种类
        private int custmerNum = 0;     // 满载人数

        public AbstractMoveable(String clas, int custmerNum, String name) {
            this.clas = clas;
            this.custmerNum = custmerNum;
            this.name = name;
        }

        public abstract void move() ;

        @Override
        public void show() {
            System.out.println("- 交通工具信息 - AbstractMoveable抽象类 -");
            System.out.println("名称：" + this.name);
            System.out.println("类型：" + this.clas);
            System.out.println("满载：" + this.custmerNum);
        }

        @Override
        public String toString() {
            return "AbstractMoveable{" +
                    "name='" + name + '\'' +
                    ", clas='" + clas + '\'' +
                    ", custmerNum=" + custmerNum +
                    '}';
        }
    }

    /**
     * 陆地工具---继承---交通工具超类---实现接口
     */
    private class LandMoveable extends AbstractMoveable implements Moveable {
        private String brandModel = "";     // 发动机型号

        public LandMoveable(String clas, int custmerNum, String name, String brandModel) {
            super(clas, custmerNum, name);
            this.brandModel = brandModel;
        }

        @Override
        public void move() {
            System.out.println("陆地工具的move方式 - LandMoveable");
            System.out.println(this.brandModel + " 发动机 1E65F 单缸 二行程");
        }

        @Override
        public void show() {
            super.show();
            System.out.println("交通工具信息 - FlyMoveable");
            System.out.println("发动机型号："+this.brandModel);
        }

        @Override
        public String toString() {
            return super.toString() + "LandMoveable{" +
                    "brandModel='" + brandModel + '\'' +
                    '}';
        }
    }

    /**
     * 飞行工具---继承---交通工具超类
     */
    private class FlyMoveable extends AbstractMoveable {
        private String propellerModel = "";     // 推进器型号

        public FlyMoveable(String clas, int custmerNum, String name, String propellerModel) {
            super(clas, custmerNum, name);
            this.propellerModel = propellerModel;
        }

        @Override
        public void move() {
            System.out.println("飞行工具的move方式 - FlyMoveable");
            System.out.println(this.propellerModel + " 推进器 向后喷气");
        }

        @Override
        public void show() {
            super.show();
            System.out.println("交通工具信息 - FlyMoveable");
            System.out.println("推进器型号："+this.propellerModel);
        }

        @Override
        public String toString() {
            return super.toString() + "FlyMoveable{" +
                    "propellerModel='" + propellerModel + '\'' +
                    '}';
        }
    }

    public <T> T createProxy(T obj) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理交通工具要调用 ->" + method.getName() + "<-方法，被代理的对象是-> " + obj.getClass().getSimpleName());
                        return method.invoke(obj, args);
                    }
                });
    }

    @Test
    public void runDemo() {
        Moveable landMoveable = new LandMoveable("陆地工具", 13,
                "奔驰", "M270发动机");
        Moveable flyMoveable = new FlyMoveable("飞行工具", 107,
                "播音747", "涡轮喷气");

        System.out.println("==========使用接口==========");
        landMoveable.move();
        landMoveable.show();
        System.out.println("===========================");
        flyMoveable.move();
        flyMoveable.show();
        System.out.println("===========================");
        System.out.println();

        System.out.println("==========使用代理==========");
        Moveable lm = createProxy(landMoveable);
        lm.move();
        lm.show();
        System.out.println("===========================");
        Moveable fm = createProxy(flyMoveable);
        fm.move();
        fm.show();
        System.out.println("===========================");
    }
}














