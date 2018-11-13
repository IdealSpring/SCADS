package cn.ccut.bridge;

/**
 * Abstractor类
 * @author zhipeng_Tong
 */
public abstract class Person {
    private Clothing clothing;
    private String type;

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void dress();
}
