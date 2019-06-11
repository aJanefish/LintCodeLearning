package com.lintcode;

import com.utils.P;

/**
 * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 * <p>
 * 所有小于k的元素移到左边
 * 所有大于等于k的元素移到右边
 * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 */

public class LintCode031 {

    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int min_Numbers = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                min_Numbers++;
            }
        }
        return min_Numbers;
    }


    public static void main(String[] args) {
        int[] ints = {3, 2, 2, 1};
        int target = 2;
        LintCode031 lintCode031 = new LintCode031();
        int flag = lintCode031.partitionArray(ints, target);
        P.pln(flag);
    }
}
