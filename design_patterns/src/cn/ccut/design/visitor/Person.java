package cn.ccut.design.visitor;

/**
 * Element
 *
 * @author zhipeng_Tong
 */
public abstract class Person {
    // 接受
    public abstract void accept(Action visitor);
}
