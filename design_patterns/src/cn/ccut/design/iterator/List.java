package cn.ccut.design.iterator;

/**
 * Aggregate
 * @author zhipeng_Tong
 */
public interface List {
    Iterator iterator();

    Object get(int index);

    int size();

    void add(Object o);
}
