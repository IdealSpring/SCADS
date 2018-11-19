package cn.ccut.mediator;

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
