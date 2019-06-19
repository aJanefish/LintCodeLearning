package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 * <p>
 * 要求时间复杂度为O(n)，空间复杂度为O(1)。
 */
public class LintCode047 {

    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     *
     * 您的提交打败了 75.20% 的提交!
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here


        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int three = nums.size() / 3;
        for (int i = 0; i < nums.size(); i++) {
            int key = nums.get(i);
            if (hashMap.containsKey(key)) {
                int old = hashMap.get(key);
                if (old + 1 > three) {
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
        LintCode047 lintCode047 = new LintCode047();
        //[99,2,99,2,99,3,3],
        List<Integer> list = new ArrayList<Integer>();
        list.add(99);
        list.add(2);
        list.add(99);
        list.add(2);
        list.add(99);
        list.add(3);
        list.add(3);
        int major = lintCode047.majorityNumber(list);
        P.pln(major);
    }
}
