package cn.ccut.iterator;

/**
 * ConcreteIterator
 * @author zhipeng_Tong
 */
public class IteratorImpl implements Iterator {
    private List list;
    private int index;

    public IteratorImpl(List list) {
        this.list = list;
    }

    @Override
    public Object next() {
        index++;
        return list.get(index - 1);
    }

    @Override
    public Object first() {
        return list.get(0);
    }

    @Override
    public Object last() {
        return list.get(list.size() - 1);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
