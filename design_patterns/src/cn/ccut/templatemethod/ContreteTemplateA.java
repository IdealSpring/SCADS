package cn.ccut.templatemethod;

/**
 * ContreteClass
 * @author zhipeng_Tong
 */
public class ContreteTemplateA extends Template {
    @Override
    protected void content() {
        System.out.println("ContreteTemplateA......打印如下内容");
        System.out.println("小二小二郎");
        System.out.println("背着书包上学堂");
    }
}
