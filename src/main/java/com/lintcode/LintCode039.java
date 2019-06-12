package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个旋转排序数组，在原地恢复其排序
 */

public class LintCode039 {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums.size() < 2) {
            return;
        }
        int size = nums.size();
        int first = nums.get(0);
        int last = nums.get(size - 1);
        while (first >= last) {
            //旋转
            int tmp = nums.remove(size - 1);
            nums.add(0, tmp);

            first = nums.get(0);
            last = nums.get(size - 1);
        }
    }

    public static void main(String[] args) {
        LintCode039 lintCode039 = new LintCode039();
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        P.pln(nums);
        lintCode039.recoverRotatedSortedArray(nums);
        P.pln(nums);
    }
}
