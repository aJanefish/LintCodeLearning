package com.lintcode;

import com.utils.P;

/**
 * 给你一个排序数组，删除其中的重复元素，使得每个数字最多出现两次，返回新的数组的长度。
 * 如果一个数字出现超过2次，则这个数字最后保留两个。
 */
public class LintCode101 {

    /**
     * @param nums: a array of integers
     * @return : return an integer
     *
     * 您的提交打败了 100.00% 的提交!
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length <= 2) {
            return length;
        }

        int tmp = nums[0];
        boolean flag = false;
        int new_length = length;
        int index = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == tmp) {
                if (flag) {
                    new_length--;
                } else {
                    flag = true;
                    nums[index++] = tmp;
                }
            } else {
                tmp = nums[i];
                flag = false;
                nums[index++] = tmp;
            }

        }
        return new_length;
    }

    public static void main(String[] args) {
        LintCode101 lintCode101 = new LintCode101();
        //	输入:  [1,1,1,2,2,3]
        //	输出: 5
        //
        //	样例解释:
        //	长度为 5，  数组为：[1,1,2,2,3]

        int[] ints = {1, 1, 1, 2, 2, 3};
        int s = lintCode101.removeDuplicates(ints);
        P.pln(s);
    }
}
