package cn.ccut.design.adapter;

/**
 * Adapter
 * @author zhipeng_Tong
 */
public class Translator implements Player {
    private ForeignCenter foreignCenter;

    public Translator(String foreignCenter) {
        this.foreignCenter = new ForeignCenter(foreignCenter);
    }

    @Override
    public void attach() {
        foreignCenter.attach();
    }

    @Override
    public void defense() {
        foreignCenter.defense();
    }
}
