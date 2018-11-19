package cn.ccut.design.mediator;

/**
 * ConcreteMediator
 * @author zhipeng_Tong
 */
public class UnitedNationsSecurityConcil extends UnitedNations {
    private USA usa;
    private Iraq iraq;

    public void setUsa(USA usa) {
        this.usa = usa;
    }

    public void setIraq(Iraq iraq) {
        this.iraq = iraq;
    }

    @Override
    public void declare(String message, Country country) {
        if (country == usa)
            iraq.getMessage(message);
        else
            usa.getMessage(message);
    }
}
