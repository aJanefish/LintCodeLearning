package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。
 * <p>
 * 要求时间复杂度为O(n)，空间复杂度为O(k)
 */

public class LintCode048 {

    /**
     * @param nums: A list of integers
     * @param k:    An integer
     * @return: The majority number
     *
     * 您的提交打败了 98.00% 的提交!
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here


        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int key_value = nums.size() / k;
        for (int i = 0; i < nums.size(); i++) {
            int key = nums.get(i);
            if (hashMap.containsKey(key)) {
                int old = hashMap.get(key);
                if (old + 1 > key_value) {
                    return key;
                }
                hashMap.put(key, old + 1);
            } else {
                hashMap.put(key, 1);
            }
        }

        //P.pln(hashMap);
        return 0;
    }

    public static void main(String[] args) {
        LintCode048 lintCode048 = new LintCode048();
        //[3,1,2,3,2,3,3,4,4,4] and k=3,
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);


       int major =  lintCode048.majorityNumber(list, 3);
        P.pln(major);
    }
}
