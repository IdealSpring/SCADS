package cn.ccut.algorithm.sort;

/**
 * 选择排序
 *
 * @param <T>
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] t) {
        int length = t.length;

        // 进行length - 1趟交换
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;   // 最小元素索引

            // 与其他元素比较
            for (int j = i + 1; j < length; j++) {
                if (less(t[j], t[minIndex])) {
                    minIndex = j;
                }
            }

            swap(t, i, minIndex);   // 交换
        }
    }
}
