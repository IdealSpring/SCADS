package cn.ccut.composite;

/**
 * Component
 * @author zhipeng_Tong
 */
public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company company);  // 添加
    public abstract void remove(Company company);   // 删除
    public abstract void display(int depth);    // 显示
    public abstract void lineOfDuty();  // 履行职责
}
