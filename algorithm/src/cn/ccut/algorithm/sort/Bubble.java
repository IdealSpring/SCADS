package cn.ccut.algorithm.sort;

/**
 * 冒泡排序
 *
 * @param <T>
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] t) {
        int length = t.length;
        boolean hasSorted = false;  // 已经有顺序，直接退出

        for (int i = length - 1; i > 0 && !hasSorted; i--) {
            hasSorted = true;

            for (int j = 0; j < i; j++) {
                if (less(t[j + 1], t[j])) {
                    hasSorted = false;
                    swap(t, j, j +1);
                }
            }
        }
    }
}
