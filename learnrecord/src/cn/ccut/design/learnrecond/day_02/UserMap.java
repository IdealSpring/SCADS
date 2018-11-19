package cn.ccut.design.learnrecond.day_02;

@FunctionalInterface
public interface UserMap {
    int delete();

    public int hashCode();

    default int insert() {
        return 1;
    }

    static int update() {
        return 2;
    }
}
