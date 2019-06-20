package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找到其中位数。
 * <p>
 * 中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
 */

public class LintCode080 {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     * 您的提交打败了 77.20% 的提交!
     */
    public int median(int[] nums) {
        // write your code here
        //排序
        java.util.Arrays.sort(nums);

        P.pln(Arrays.toString(nums));
        int flag = nums.length % 2;
        if (flag == 1) {
            return nums[nums.length / 2 ];
        }
        return nums[nums.length / 2-1];
    }

    public static void main(String[] args) {
        LintCode080 lintCode080 = new LintCode080();
        int[] ints = {7, 9, 4, 5};
        int mid = lintCode080.median(ints);
        P.pln(mid);
    }
}
