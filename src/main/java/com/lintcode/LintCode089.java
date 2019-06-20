package com.lintcode;

import com.utils.P;

/**
 * 给定 n 个不同的正整数，整数 k（k <= n）以及一个目标数字 target。
 * 在这 n 个数里面找出 k 个数，使得这 k 个数的和等于目标数字，求问有多少种方案？
 */
public class LintCode089 {

    /**
     * @param arr:    An integer array
     * @param k:      A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] arr, int k, int target) {
        // write your code here
        int n = arr.length;
        int num = 0;

        if (k < 0 || k > n) {
            return num;
        }
        int[][] f = new int[k + 1][target + 1];
        f[0][0] = 1;
        //使用i-1的原因，是因为这里把三维数组合并成了二维数组
        //f[i][k][target] = f[i-1][k][target] + f[i-1][k-1][target-arr[i]]
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                for (int s = target; s >= arr[i]; s--) {
                    f[j][s] = f[j][s] + f[j - 1][s - arr[i]];
                }
            }
        }
        return f[k][target];

    }

    public static void main(String[] args) {
        LintCode089 lintCode089 = new LintCode089();
        int[] ints = {1, 2, 3, 4, 5, 6};
        int s = lintCode089.kSum(ints, 3, 10);
        P.pln(s);
    }
}
