package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 */
public class LintCode056 {

    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     *
     * 您的提交打败了 91.00% 的提交!
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {

                int tar = target - numbers[i];
                for (int i1 = i + 1; i1 < numbers.length; i1++) {
                    if(numbers[i1] == tar){
                        result[0] = i;
                        result[1] = i1;
                        return result;
                    }
                }

        }
        return null;
    }

    public static void main(String[] args) {
        LintCode056 lintCode056 = new LintCode056();
        //[2, 7, 11, 15], target = 9
        int[] ints = {2, 7, 11, 15};

        int target = 9;
        int[] ss = lintCode056.twoSum(ints, target);
        P.pln(Arrays.toString(ss));
    }
}
