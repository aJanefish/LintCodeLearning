package com.lintcode;

import com.utils.P;

import java.util.List;

/**
 * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。
 */


public class LintCode045 {

    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {

            //[0,i] [i+1,nums.length-1]
            int tmp_max = maxSubArray(nums, 0, i);
            int tmp_min = minSubArray(nums, i + 1, nums.length - 1);

            int tmp = Math.abs((tmp_max - tmp_min));
            if (tmp > max) {
                P.pln("A " + i + " : " + tmp_max + " : " + tmp_min + " [" + (i + 1) + "," + (nums.length - 1) + "]");
                max = tmp;
            }

            tmp_min = minSubArray(nums, 0, i);
            tmp_max = maxSubArray(nums, i + 1, nums.length - 1);

            tmp = Math.abs((tmp_max - tmp_min));
            if (tmp > max) {
                P.pln("B " + i + " : " + tmp_max + " : " + tmp_min);


                max = tmp;
            }
        }

        return max;
    }

    //[start,end]
    private int maxSubArray(int[] nums, int start, int end) {
        // write your code here
        int max = nums[start];

        for (int i = start + 1; i <= end; i++) {

            //求[0,i]的最小子数组
            int tmp_max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i1 = i; i1 >= 0; i1--) {
                sum += nums[i1];
                if (sum > tmp_max) {
                    tmp_max = sum;
                }
            }

            if (max < tmp_max) {
                max = tmp_max;
            }
        }

        return max;
    }

    //[start,end]
    private int minSubArray(int[] nums, int start, int end) {
        // write your code here
        int min = nums[start];

        for (int i = start + 1; i <= end; i++) {

            //求[0,i]的最小子数组
            int tmp_min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i1 = i; i1 >= start; i1--) {
                sum += nums[i1];
                if (sum < tmp_min) {
                    tmp_min = sum;
                }
            }

            if (min > tmp_min) {
                min = tmp_min;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        LintCode045 lintCode045 = new LintCode045();
        int[] ints = {-2, 0, 0, 1, -1, -1};
        int max = lintCode045.maxDiffSubArrays(ints);
        P.pln(max);
    }
}
