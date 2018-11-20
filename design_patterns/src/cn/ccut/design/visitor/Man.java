package cn.ccut.design.visitor;

/**
 * ConcreteElement
 *
 * @author zhipeng_Tong
 */
public class Man extends Person {
    @Override
    public void accept(Action visitor) {
        visitor.getManResult(this);
    }
}
