package cn.ccut.algorithm.sort;

/**
 * 希尔排序
 *
 * @param <T>
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] t) {
        int length = t.length;
        int d = length / 2;

        while (d >= 1) {
            for (int i = d; i < length; i++) {
                for (int j = i; j >= d && less(t[j], t[j - d]); j -= d) {
                    swap(t, j - d, j);
                }
            }

            d = d / 2;
        }
    }
}
