package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给定一个排序数组，在原数组中“删除”重复出现的数字，使得每个元素只出现一次，并且返回“新”数组的长度。
 * <p>
 * 不要使用额外的数组空间，必须在不使用额外空间的条件下原地完成。
 */

public class LintCode100 {

    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here

        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int tmp = nums[0];
        int new_index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (tmp == nums[i]) {
                length--;
            } else {
                tmp = nums[i];
                nums[new_index] = tmp;
                new_index++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LintCode100 lintCode100 = new LintCode100();
        int[] ints = {-14, -14, -13, -13, -13, -13, -13, -13, -13, -12, -12, -12, -12, -11, -10, -9, -9, -9, -8, -7, -5, -5, -5, -5, -4, -3, -3, -2, -2, -2, -2, -1, -1, -1, -1, -1, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 14, 14, 14, 14, 15, 16, 16, 16, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 23, 23, 24, 25, 25};
        int ss = lintCode100.removeDuplicates(ints);
        P.pln(Arrays.toString(ints));
        P.pln(ss);
    }

}

