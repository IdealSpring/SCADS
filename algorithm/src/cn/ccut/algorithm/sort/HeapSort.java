package cn.ccut.algorithm.sort;

/**
 * 堆排序
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] t) {
        int length = t.length - 1;  // 索引

        for (int i = length / 2; i >= 1; i--)
            sink(t, i, length);

        while (length > 1) {
            swap(t, 1, length--);
            sink(t, 1, length);
        }
    }

    /**
     * 小元素下沉
     *
     * @param ts
     * @param k
     * @param length
     */
    private void sink(T[] ts, int k, int length) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && ts[j].compareTo(ts[j + 1]) < 0)
                j++;
            if (ts[k].compareTo(ts[j]) > 0)
                break;

            swap(ts, k, j);
            k = j;
        }
    }
}
