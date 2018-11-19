package cn.ccut.design.mediator;

/**
 * ConcreteColleauge
 * @author zhipeng_Tong
 */
public class Iraq extends Country {
    public Iraq(UnitedNations unitedNations) {
        super(unitedNations);
    }

    // 发布消息
    public void declare(String message) {
        mediator.declare(message, this);
    }

    // 获得消息
    public void getMessage(String message) {
        System.out.println("伊拉克获得对方的消息：" + message);
    }
}
