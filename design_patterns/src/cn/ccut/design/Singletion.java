package cn.ccut.design;

public class Singletion {
    private Singletion() {}

    private static class SingletionHolder {
        private static final Singletion SINGLETION = new Singletion();
    }

    public static Singletion getInstance() {
        return SingletionHolder.SINGLETION;
    }
}
