package cn.ccut.templatemethod;

public class Client {
    public static void main(String[] args) {
        Template contrete = new ContreteTemplateA();
        contrete.print();

        System.out.println();
        contrete = new ContreteTemplateB();
        contrete.print();
    }
}
