package cn.ccut.algorithm.sort;

/**
 * 插入排序
 *
 * @param <T>
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] t) {
        int length = t.length;

        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(t[j], t[j - 1]); j--) {
                swap(t, j - 1, j);
            }
        }
    }
}
