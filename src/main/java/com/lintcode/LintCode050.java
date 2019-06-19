package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组A。
 * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。请输出B。
 */
public class LintCode050 {

    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     *
     * 您的提交打败了 91.60% 的提交!
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here

        List<Long> longs = new ArrayList<Long>();
        if (nums.size() == 1) {
            longs.add(1l);
            return longs;
        }
        List<Long> list = new ArrayList<Long>();
        List<Long> list1 = new ArrayList<Long>();
        long cross = 1L;
        for (int i = 0; i < nums.size(); i++) {
            cross *= nums.get(i);
            list.add(cross);
        }
        // P.pln(list);
        cross = 1L;
        for (int i = nums.size() - 1; i >= 0; i--) {
            cross *= nums.get(i);
            list1.add(0, cross);
        }

        long left = 1;
        long right = 1;
        for (int i = 0; i < nums.size(); i++) {

            if (i == 0) {
                left = 1;
                right = list1.get(i + 1);
                longs.add(left * right);
                continue;
            } else if (i == (nums.size() - 1)) {
                left = list.get(i - 1);
                right = 1;
                longs.add(left * right);
            } else {
                left = (long)list.get(i - 1);
                right = (long)list1.get(i + 1);
                longs.add(left * right);
            }
        }
        return longs;
    }

    public static void main(String[] args) {
        LintCode050 lintCode050 = new LintCode050();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        P.pln(list);

        List<Long> ss = lintCode050.productExcludeItself(list);
        P.pln(ss);
    }
}
