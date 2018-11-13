package cn.ccut.adapter;

/**
 * Adaptee
 * @author zhipeng_Tong
 */
public class ForeignCenter {
    private String name;

    public ForeignCenter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attach() {
        System.out.println(String.format("外籍中锋 %s 进攻", name));
    }

    public void defense() {
        System.out.println(String.format("外籍中锋 %s 防守", name));
    }
}
