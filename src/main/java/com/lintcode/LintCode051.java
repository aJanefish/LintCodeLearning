package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组来表示排列，找出其上一个排列。
 * 例1:
 * <p>
 * 输入:[1]
 * 输出:[1]
 * 例2:
 * <p>
 * 输入:[1,3,2,3]
 * 输出:[1,2,3,3]
 * 例3:
 * <p>
 * 输入:[1,2,3,4]
 * 输出:[4,3,2,1]
 */

public class LintCode051 {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums.size() == 1)
            return nums;

        for (int i = nums.size() - 1; i > 0; i--) {
            if (nums.get(i) < nums.get(i - 1)) {
                int remove = nums.remove(i);
                nums.add(i-1,remove);
                return nums;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.size(); i++) {
            list.add(0, nums.get(i));
        }

        return list;
    }

    public static void main(String[] args) {
        LintCode051 lintCode051 = new LintCode051();
        //[1,3,2,3]
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);

        P.pln(list);
        List<Integer> ss = lintCode051.previousPermuation(list);
        P.pln(ss);
    }
}
