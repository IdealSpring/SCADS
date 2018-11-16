package cn.ccut.templatemethod;

/**
 * AbstractClass
 * @author zhipeng_Tong
 */
public abstract class Template {
    public void print() {
        System.out.println("打印机开始打印：");
        content();
    }

    // 需要子类实现，也就是模板里需要填的内容
    protected abstract void content();
}
