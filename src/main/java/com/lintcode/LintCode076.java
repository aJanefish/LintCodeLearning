package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 * 要求时间复杂度为O(n^2) 或者 O(nlogn)
 */

public class LintCode076 {

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     *
     * 您的提交打败了 100.00% 的提交!
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return 0;
        }

        int[] flag = new int[nums.length];
        flag[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            boolean find = false;
            int tmp_max = Integer.MIN_VALUE;
            for (int i1 = i - 1; i1 >= 0; i1--) {//
                if (nums[i1] < tmp) {
                    if (flag[i1] > tmp_max) {
                        tmp_max = flag[i1];
                        find = true;
                    }
                }
            }
            if (find) {
                flag[i] = tmp_max + 1;
                if (flag[i] > max) {
                    max = flag[i];
                }
            } else {
                flag[i] = 1;

            }
        }
        return max;
    }

    public static void main(String[] args) {
        LintCode076 lintCode076 = new LintCode076();
        int[] ints = {4, 2, 4, 5, 3, 7};
        int nums = lintCode076.longestIncreasingSubsequence(ints);
        P.pln(nums);
    }
}
