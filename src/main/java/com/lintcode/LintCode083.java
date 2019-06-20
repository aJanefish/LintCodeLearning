package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给出3*n + 1 个非负整数，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
 */
public class LintCode083 {

    /**
     * @param A: An integer array
     * @return: An integer
     *
     * 您的提交打败了 52.00% 的提交!
     */
    public int singleNumberII(int[] A) {
        // write your code here
        int[] result = new int[32];

        for (int i = 0; i < A.length; i++) {
            int tmp = A[i];
            for (int index = 0; index < result.length; index++) {
                int bits = (tmp >> index) & 0x01;
                if (bits != 0) {
                    int tmp_result = result[index];
                    if (tmp_result == 0) {
                        result[index] = 1;
                    } else if (result[index] == 1) {
                        result[index] = 2;
                    } else {
                        result[index] = 0;
                    }
                    //result[index] = (result[index] + bits) % 3;
                }
            }
        }
        //P.pln(Arrays.toString(result));
        int base = 1;
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum = sum + base * result[i];
            base = base * 2;
        }
        return sum;
    }

    public static void main(String[] args) {

        LintCode083 lintCode083 = new LintCode083();
        int[] ints = {1, 1, 2, 3, 3, 3, 2, 2, 4, 1};
        int nums = lintCode083.singleNumberII(ints);
        P.pln(nums);
    }
}
