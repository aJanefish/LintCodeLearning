package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 合并两个排序的整数数组A和B变成一个新的数组。
 */
public class LintCode064 {

    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     * 您的提交打败了 83.40% 的提交!

     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        int index = A.length - 1;
        for (; i >= 0 && j >= 0; ) {
            if (A[i] > B[j]) {
                A[index] = A[i];
                i--;
                index--;
            } else {
                A[index] = B[j];
                j--;
                index--;
            }
        }

        if (i >= 0) {

        } else {
            P.pln(j + " - " + index);
            for (int j1 = j; j1 >= 0; j1--) {
                A[index] = B[j1];
                index--;
            }
        }
    }

    public static void main(String[] args) {

        //输入：[1, 2, 3]  3  [4,5]  2
        //输出：[1,2,3,4,5]
        LintCode064 lintCode064 = new LintCode064();
        //[]
        //0
        //[2,3,4,5,6,10]
        //6
        int[] a = {0, 0, 0, 0, 0, 0};
        int[] b = {2, 3, 4, 5, 6, 10};
        P.pln(Arrays.toString(a));
        lintCode064.mergeSortedArray(a, 0, b, 6);
        P.pln(Arrays.toString(a));

    }
}
