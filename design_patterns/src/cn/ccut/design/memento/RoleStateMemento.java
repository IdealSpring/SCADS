package cn.ccut.design.memento;

/**
 * Memento
 * @author zhipeng_Tong
 */
public class RoleStateMemento {
    private int liftValue;
    private int attachPower;
    private int defensivePower;

    public RoleStateMemento(int liftValue, int attachPower, int defensivePower) {
        this.liftValue = liftValue;
        this.attachPower = attachPower;
        this.defensivePower = defensivePower;
    }

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
}
