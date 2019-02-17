package cn.ccut.algorithm.sort;

import java.util.Arrays;

/**
 * 排序测试类
 *      1.选择排序
 *      2.冒泡排序
 *      3.插入排序
 *      4.快速排序
 *      5.希尔排序
 *      6.归并排序-
 *      7.堆排序-
 */
public class Demo {
    public static void main(String[] args) {
        Integer[] array = {11, 100, 2, 8, 99, 72, 99, 15, 5, 1};

        // 选择排序
//        new SelectSort<Integer>().sort(array);

        // 冒泡排序
//        new Bubble<Integer>().sort(array);

        // 插入排序
//        new InsertSort<Integer>().sort(array);

        // 快速排序
//        new QuickSort<Integer>().sort(array);

        // 希尔排序
        new ShellSort<Integer>().sort(array);

        System.out.println(Arrays.toString(array));
    }
}
