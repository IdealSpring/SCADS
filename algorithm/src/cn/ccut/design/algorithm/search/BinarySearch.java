package cn.ccut.design.algorithm.search;

import java.util.Scanner;

/**
 * 二分查找 Demo
 *
 * @author zhipeng-Tong
 */
public class BinarySearch {
    public static void main(String[] args) {
        // 已经排序好的数组
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 获取查找值
        Scanner sc = new Scanner(System.in);
        System.out.print("输入要查找值(0-9):");
        int findValue = sc.nextInt();

        // 查找
        int findIndexValue = searchIndexValue(array, findValue);
        System.out.println("查找值下标为:" + findIndexValue);
    }

    /**
     * 二分查找值元素
     *
     * @param array
     *          已排序的数组
     * @param findValue
     *          要查找的值
     * @return
     *          找到值时返回值的下标，没找到时返回-1
     */
    private static int searchIndexValue(int[] array, int findValue) {
        // 起始下标，和结束小标，声明中间值。
        int start = 0;
        int end = array.length - 1;
        int mid;

        // 查找区域的左边界，小于等于查找区域的右边界
        while (start <= end) {
            // 计算序列中间下标位置
            mid = (end + start) / 2;

            if (findValue == array[mid]) { // 如果待查找值value == 中间位置的元素的值, 返回当前中间位置下标
                return mid;
            } else if (findValue < array[mid]) { //如果带查找值value < 序列中间位置元素的值, 右边界等于中间位置-1
                end = mid - 1;
            } else { //如果待查找值value > 序列中间位置元素的值, 左边界等于中间位置+1
                start = mid + 1;
            }
        }

        return -1;
    }
}
