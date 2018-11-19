package cn.ccut.design.builder;

/**
 * 对象构造接口，约束行为
 * @author zhipeng_Tong
 */
public interface PersonBuilder {
    void buildHead();   // 构建头

    void buildBody();   // 构建身体

    void buildFoot();   // 脚

    Person getPerson();   // 获取
}
