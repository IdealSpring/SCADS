package cn.ccut.design.memento;

/**
 * Originator
 * @author zhipeng_Tong
 */
public class GameRole {
    private int liftValue;  // 生命值
    private int attachPower;    // 攻击力
    private int defensivePower; // 防御力

    public int getLiftValue() {
        return liftValue;
    }

    public void setLiftValue(int liftValue) {
        this.liftValue = liftValue;
    }

    public int getAttachPower() {
        return attachPower;
    }

    public void setAttachPower(int attachPower) {
        this.attachPower = attachPower;
    }

    public int getDefensivePower() {
        return defensivePower;
    }

    public void setDefensivePower(int defensivePower) {
        this.defensivePower = defensivePower;
    }

    // 展示状态
    public void displayState() {
        System.out.println("角色状态信息: ");
        System.out.println(String.format("生命值: %d", liftValue));
        System.out.println(String.format("攻击力: %d", attachPower));
        System.out.println(String.format("防御力: %d", attachPower));
    }

    // 初始化状态
    public void initialState() {
        this.liftValue = 100;
        this.attachPower = 100;
        this.defensivePower = 100;
    }

    // 战斗
    public void fight() {
        this.liftValue = 0;
        this.attachPower = 0;
        this.defensivePower = 0;
    }

    // 保存角色状态
    public RoleStateMemento saveState() {
        return new RoleStateMemento(this.liftValue, this.attachPower, this.defensivePower);
    }

    // 回复角色状态
    public void recoveryState(RoleStateMemento memento) {
        this.liftValue = memento.getLiftValue();
        this.attachPower = memento.getAttachPower();
        this.defensivePower = memento.getDefensivePower();
    }
}
