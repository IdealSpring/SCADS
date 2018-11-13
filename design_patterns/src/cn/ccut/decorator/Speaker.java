package cn.ccut.decorator;

/**
 * ConcreteComponent类，即Person的实现类
 * @author zhipeng_Tong
 */
public class Speaker implements Person {
    @Override
    public void speak() {
        System.out.println("时光的荏苒");
    }
}
