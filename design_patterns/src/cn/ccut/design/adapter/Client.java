package cn.ccut.design.adapter;

public class Client {
    public static void main(String[] args) {
        Player forward = new Forward("巴蒂尔");
        forward.attach();

        Player foreignCenter = new Translator("姚明");
        foreignCenter.attach();
        foreignCenter.defense();
    }
}
