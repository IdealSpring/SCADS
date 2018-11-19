package cn.ccut.design.adapter;

public class Forward implements Player {
    private String name;

    public Forward(String name) {
        this.name = name;
    }

    @Override
    public void attach() {
        System.out.println(String.format("前锋 %s 进攻", name));
    }

    @Override
    public void defense() {
        System.out.println(String.format("后卫 %s 防守", name));
    }
}
