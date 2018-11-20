package cn.ccut.design.visitor;

/**
 * ConcreteElement
 *
 * @author zhipeng_Tong
 */
public class Woman extends Person {
    @Override
    public void accept(Action visitor) {
        visitor.getWomanReslt(this);
    }
}
