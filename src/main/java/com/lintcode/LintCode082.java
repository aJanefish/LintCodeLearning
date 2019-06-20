package com.lintcode;

import com.utils.P;

/**
 * 给出 2 * n + 1个数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 * <p>
 * 挑战
 * 一次遍历，常数级的额外空间复杂度
 */
public class LintCode082 {

    /**
     * @param A: An integer array
     * @return: An integer
     *
     * 您的提交打败了 80.00% 的提交!
     */
    public int singleNumber(int[] A) {
        // write your code here
        int tmp =  A[0];
        for (int i = 1; i < A.length; i++) {
            tmp = tmp^A[i];
        }
        return tmp;
    }

    public static void main(String[] args) {
        int x = 0xff;
        int y = 0x00;
        int z = 0xff;
        P.pln(x ^ y);
        P.pln(x ^ z);

        LintCode082 lintCode082 = new LintCode082();
        int[] ints = {1,1,2,2,3,4,4};
        int ss = lintCode082.singleNumber(ints);
        P.pln(ss);
    }
}
