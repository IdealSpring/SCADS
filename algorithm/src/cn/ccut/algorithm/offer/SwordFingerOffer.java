package cn.ccut.algorithm.offer;

import java.util.Arrays;

/**
 * 剑指Offer算法题
 *
 * @author zhipeng_Tong 2019年2月17日08:54:10
 */
public class SwordFingerOffer {
    public static void main(String[] args) {
        SwordFingerOffer offer = new SwordFingerOffer();

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(offer.duplicate(nums, nums.length, duplication));
        System.out.println(Arrays.toString(duplication));
    }

    /**
     * 3. 数组中重复的数字
     *
     * 题目描述:
     *     在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     *
     * 解题思路：
     * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        // 数组检查
        if (nums == null || length <= 0)
            return false;

        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }

        return false;
    }

    /**
     * 交换元素位置
     *
     * @param nums  数组
     * @param i 待交换元素
     * @param j 待交换元素
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
