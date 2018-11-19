package cn.ccut.design.algorithm.arrayandlink.array;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 自定义ArrayList集合
 * @param <E>
 */
public class MyArrayList<E> implements Iterable<E>{
    // 设置默认容量为10
    private static final int DEFAULT_CAPACITY = 10;
    // 默认数组
    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};
    // 数组的长度
    private int size;
    // 保存数据的数组
    private Object[] elementData;


    // 构造方法
    public MyArrayList() {
        this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
    }

    // 可知调用，指定集合大小
    private void ensureCapacity(int minCapacity) {
        int minExpand = this.elementData != DEFAULT_EMPTY_ELEMENTDATA ? 0 : DEFAULT_CAPACITY;

        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    // 判断minCapacity大小
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(minCapacity));
    }

    // 计算扩充容量的大小
    private int calculateCapacity(int minCapacity) {
        if (this.elementData == DEFAULT_EMPTY_ELEMENTDATA) {
            return Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity > this.elementData.length) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        if (newCapacity > Integer.MAX_VALUE - 8) {
            newCapacity = Integer.MAX_VALUE;
        }
        this.elementData = Arrays.copyOf(this.elementData, newCapacity);
    }

    public int size() {
        return this.size;
    }

    public int getLength() {
        return this.elementData.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 添加元素
    public boolean add(E element) {
        ensureCapacityInternal(this.size + 1);
        this.elementData[this.size++] = element;
        return true;
    }

    // 在指定位置添加
    public void add(int index, E element) {
        ensureCapacityInternal(this.size + 1);
        System.arraycopy(this.elementData, index, this.elementData, index + 1, size - index);
        this.elementData[index] = element;
        size++;
    }

    // 清空所有数据
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elementData[i] = null;
        }

        this.size = 0;
    }

    // 删除第一次出现的指定元素
    public boolean remove(Object element) {
        if (element == null) {
            for (int index = 0; index < this.size; index++) {
                if (this.elementData[index] == null) {
                    remove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < this.size; index++) {
                if (this.elementData[index].equals(element)) {
                    remove(index);
                    return true;
                }
            }
        }

        return false;
    }

    // 删除指定索引的元素
    public E remove(int index) {
        E oldValue = (E)this.elementData[index];
        int moveElementNum = this.size - 1 - index;
        if (moveElementNum > 0) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, moveElementNum);
        }
        this.elementData[--this.size] = null;

        return oldValue;
    }

    // 替换指定索引处的元素
    public E set(int index, E element) {
        E oldValue = (E)this.elementData[index];
        this.elementData[index] = element;
        return oldValue;
    }

    public E get(int index) {
        return (E)this.elementData[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.elementData);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        // 数据指针
        int cursor;
        // 保存指针上次位置
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            if (cursor >= size) {
                new Exception("没有元素");
            }
            if (cursor >= elementData.length) {
                new Exception("数组索引越界");
            }

            lastRet = cursor;
            return (E)elementData[cursor++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }
}
