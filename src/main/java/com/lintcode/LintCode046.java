package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * <p>
 * 挑战
 * 要求时间复杂度为O(n)，空间复杂度为O(1)
 */
public class LintCode046 {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     *
     * 您的提交打败了 94.00% 的提交!
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here

        int major = nums.get(0);
        int major_nums = 1;
        int mid = nums.size() / 2;
        for (int i = 1; i < nums.size(); i++) {
            if (major == nums.get(i)) {
                major_nums++;
                if (major_nums >mid ) {
                    break;
                }
            } else {
                major_nums--;
                if (major_nums == 0) {
                    major = nums.get(i);
                    major_nums = 1;
                }
            }
        }
        return major;
    }

    public static void main(String[] args) {

        LintCode046 lintCode046 = new LintCode046();
        List<Integer> list = new ArrayList<Integer>();
        //[1, 1, 1, 1, 2, 2, 2]
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        int major = lintCode046.majorityNumber(list);
        P.pln(major);
    }
}