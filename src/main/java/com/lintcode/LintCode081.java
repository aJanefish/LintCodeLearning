package com.lintcode;

//数字是不断进入数组的，在每次添加一个新的数进入数组的同时返回当前新数组的中位数。

import com.utils.P;

import java.util.Arrays;

public class LintCode081 {

    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     * 您的提交打败了 80.20% 的提交!
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int[] result = new int[nums.length];
        int[] nums_new = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums_new[i] = nums[i];
                result[i] = nums[i];
                continue;
            }
            nums_new[i] = nums[i];
            sorts(nums_new, i);
            int flag = (i + 1) % 2;
            if (flag == 1) {
                result[i] = nums_new[(i + 1) / 2];
            } else
                result[i] = nums_new[(i + 1) / 2 - 1];
        }

        return result;
    }

    //[0,i+1)
    private void sorts(int[] nums_new, int length) {
        //P.pln(length + " - " + Arrays.toString(nums_new));
        int start = 0;
        int end = length;
        int mid = (start + end) / 2;
        int value = nums_new[length];
        int value_index = 0;
        while (true) {
            //P.pln(start + " - " + mid + " - " + end);
            if (start == mid) {
                if (nums_new[start] < value) {
                    value_index = mid + 1;
                } else {
                    value_index = mid;
                }
                break;
            }

            if (nums_new[mid] < value) {
                start = mid;
                mid = (start + end) / 2;
            } else if (nums_new[mid] > value) {
                end = mid;
                mid = (start + end) / 2;
            } else {
                value_index = mid + 1;
                break;
            }
        }

        //移动
        if (value_index != length) {
            for (int i = length - 1; i >= value_index; i--) {
                nums_new[i + 1] = nums_new[i];
            }
            nums_new[value_index] = value;
        }
    }


    public static void main(String[] args) {
        LintCode081 lintCode081 = new LintCode081();
        //输入: [4,5,1,3,2,6,0]
        //输出: [4,4,4,3,3,3,3]
        int[] ints = {4, 5, 1, 3, 2, 6, 0};
        int[] ints1 = lintCode081.medianII(ints);
        P.pln(Arrays.toString(ints1));
    }
}
