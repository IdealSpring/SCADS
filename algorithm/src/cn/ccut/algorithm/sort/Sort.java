package cn.ccut.algorithm.sort;

/**
 * 排序算法基类
 *
 * @param <T>
 */
public abstract class Sort<T extends Comparable<T>> {
    // 排序
    public abstract void sort(T[] t);

    // 比较两个参数
    protected boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    // 交换
    protected void swap(T[] t, int i, int j) {
        T temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
}
