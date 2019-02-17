package cn.ccut.algorithm.sort;
/**
 * 快速排序
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] t) {
        sort(t, 0, t.length - 1);
    }

    private void sort(T[] t, int l, int h) {
        if (l >= h)     // 划分区间，地位大于等于高位停止递归
            return;

        int j = partition(t, l, h); // 划分区间
        sort(t, l, j - 1);
        sort(t, j + 1, h);
    }

    private int partition(T[] t, int l, int h) {
        int i = l, j = h + 1;
        T midVal = t[l];

        while (true) {
            while (less(t[++i], midVal) && i != h); // 从左端向右扫描找到第一个大于等于它的元素
            while (less(midVal, t[--j]) && j != l); // 从右端向左扫描找到第一个小于等于它的元素

            if (i >= j)
                break;

            swap(t, i, j);
        }

        swap(t, l, j);  // 将切分元素和j索引元素交换位置
        return j;
    }
}
