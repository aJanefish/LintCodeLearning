package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组，找到一个具有最小和的连续子数组。返回其最小和。
 */
public class LintCode044 {

    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     * 思路：
     * 已知[0,i]的最小子数组
     * 求[0..i,i+1]的最小子数组
     * 您的提交打败了 28.00% 的提交!
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int min = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {

            //求[0,i]的最小子数组
            int tmp_min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i1 = i; i1 >= 0; i1--) {
                sum += nums.get(i1);
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

    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     * 您的提交打败了 28.00% 的提交!
     */
    public int minSubArray_two(List<Integer> nums) {
        // write your code here
        // write your code here

        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean has = false;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) <= 0) {
                has = true;
            }
            if (i == 0) {
                min = nums.get(i) ;
                sum += nums.get(i) ;
                continue;
            }

            if (sum >= 0 && nums.get(i)  < 0) {
                sum = nums.get(i) ;
            } else if (sum >= 0 && nums.get(i)  >= 0) {
                sum = sum < nums.get(i)  ? sum : nums.get(i) ;
            } else {
                sum += nums.get(i) ;
            }

            if (has && sum >= 0) sum = 0;

            if (sum < min) {
                min = sum;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LintCode044 lintCode044 = new LintCode044();
        //[1, -1, -2, 1]
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(-1);
        list.add(-2);
        list.add(1);
        int min = lintCode044.minSubArray(list);
        P.pln(min);

        min = lintCode044.minSubArray_two(list);
        P.pln(min);
    }
}
