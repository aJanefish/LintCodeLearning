package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 * <p>
 * O(n x m) time and O(m) memory.
 * <p>
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 */

public class LintCode092 {

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     * <p>
     * <p>
     * 您的提交打败了 33.60% 的提交!
     * 动态规划问题
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int[][] flag = new int[A.length + 1][m + 1];

        for (int i = 0; i < A.length; i++) {
            int backage = A[i];
            for (int backage_size = 1; backage_size <= m; backage_size++) {
                if (backage <= backage_size) {
                    int max = flag[i][backage_size] > flag[i + 1][backage_size - 1] ? flag[i][backage_size] : flag[i + 1][backage_size - 1];
                    int max1 = backage + flag[i][backage_size - backage];
                    flag[i + 1][backage_size] = max > max1 ? max : max1;
                } else {
                    int max = flag[i][backage_size] > flag[i + 1][backage_size - 1] ? flag[i][backage_size] : flag[i + 1][backage_size - 1];
                    flag[i + 1][backage_size] = max;
                }
            }
        }

        for (int i = 0; i <= A.length; i++) {
            P.pln(Arrays.toString(flag[i]));
        }

        return flag[A.length][m];
    }

    public static void main(String[] args) {
        LintCode092 lintCode092 = new LintCode092();
        //[3,4,8,5], backpack size=10
        int[] ints = {3, 4, 8, 5};
        int ss = lintCode092.backPack(10, ints);
        P.pln(ss);

    }
}
