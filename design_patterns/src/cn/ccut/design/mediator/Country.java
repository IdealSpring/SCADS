package cn.ccut.design.mediator;

/**
 * Colleauge
 * @author zhipeng_Tong
 */
public abstract class Country {
    protected UnitedNations mediator;

    public Country(UnitedNations unitedNations) {
        this.mediator = unitedNations;
    }
}
