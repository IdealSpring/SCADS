package cn.ccut.design.cor;

/**
 * Handler
 *
 * @author zhipeng_Tong
 */
public abstract class Manager {
    protected String name;  // 姓名
    protected Manager superior; // 上级管理者

    public Manager(String name) {
        this.name = name;
    }

    // 设置管理者的上级
    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    // 申请请求
    public abstract void requestApplications(Requset requset);
}
