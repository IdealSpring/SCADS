package cn.ccut.design.algorithm.other;

import java.util.Scanner;

/**
 * 欧几里得算法 求两个数的最大公因数
 */
public class EuclideanAlgorithm {
    public static void main(String[] args) {
        System.out.print("请输入第一个数:");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        System.out.print("请输入第二个数:");
        int n = sc.nextInt();

        // 计算最大公因数
        int result = gcd(m, n);
        System.out.println("最大公因数:" + result);
    }

    /**
     * 欧几里得算法 计算两个数的最大公因数
     *
     * @param m
     *          输入待计算值
     * @param n
     *          输入待计算值
     * @return
     *          返回值
     */
    private static int gcd(int m, int n) {
        // 比较m和n的值大小，使m的值大于n
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        // 取余计算
        while (n != 0) {
            int rem = m % n;
            m = n;
            n = rem;
        }

        return m;
    }

}
