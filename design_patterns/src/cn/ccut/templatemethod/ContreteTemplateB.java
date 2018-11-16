package cn.ccut.templatemethod;

/**
 * ContreteClass
 * @author zhipeng_Tong
 */
public class ContreteTemplateB extends Template {
    @Override
    protected void content() {
        System.out.println("ContreteTemplateB......打印如下内容");
        System.out.println("太阳当空照");
        System.out.println("小鸟说早早早");
    }
}
