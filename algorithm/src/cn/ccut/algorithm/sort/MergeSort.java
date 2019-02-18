package cn.ccut.algorithm.sort;

/**
 * 归并排序
 *
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    private T[] aux;

    @Override
    public void sort(T[] t) {
        aux = (T[]) new Comparable[t.length];
        sort(t, 0, t.length - 1);
    }

    private void sort(T[] t, int l, int h) {
        if (l >= h) // 递归结束条件
            return;

        int mid = l + (h - l) / 2;
        sort(t, l, mid);
        sort(t, mid + 1, h);
        merge(t, l, mid, h);
    }

    private void merge(T[] t, int l, int mid, int h) {
        int i = l, j = mid + 1;

        for (int k = l; k <= h; k++) {  // 将数组复制到辅助数组中
            aux[k] = t[k];
        }

        for (int k = l; k <= h; k++) {
            if (i > mid) {  // 低位数组都排完了，剩下的直接用高位数组填充
                t[k] = aux[j++];
            } else if (j > h) {  // 高位数组都排完了，剩下的直接用低位数组填充
                t[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) < 0) {
                t[k] = aux[i++];
            } else {
                t[k] = aux[j++];
            }
        }
    }
}
