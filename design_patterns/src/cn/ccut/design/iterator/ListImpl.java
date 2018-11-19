package cn.ccut.design.iterator;

/**
 * ConcreteAggregate
 * @author zhipeng_Tong
 */
public class ListImpl implements List {
    private Object[] list;
    private int index;
    private int size;

    public ListImpl() {
        this.list = new Object[100];
        this.index = 0;
        this.size = 0;
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl(this);
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(Object o) {
        list[index++] = o;
        size++;
    }
}
