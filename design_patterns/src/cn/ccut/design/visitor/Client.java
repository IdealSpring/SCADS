package cn.ccut.design.visitor;

public class Client {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new Man());
        o.attach(new Woman());

        // 成功时候反映
        Success success = new Success();
        o.display(success);

        // 失败时候反映
        Failing failing = new Failing();
        o.display(failing);
    }
}
