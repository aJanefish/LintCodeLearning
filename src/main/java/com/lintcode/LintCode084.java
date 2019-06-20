package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字
 * <p>
 * 挑战
 * O(n)时间复杂度，O(1)的额外空间复杂度
 */
public class LintCode084 {

    /**
     * @param A: An integer array
     * @return: An integer array
     * <p>
     * 您的提交打败了 62.60% 的提交!
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        int tmp = A[0];
        for (int i = 1; i < A.length; i++) {
            tmp = tmp ^ A[i];
        }
        List<Integer> listA = new ArrayList<Integer>();
        List<Integer> listB = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        int flag = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (tmp >> i) & 1;
            if (bit == 1) {
                flag = i;
                break;
            }
        }

        //分组
        for (int i = 0; i < A.length; i++) {
            int bit = (A[i] >> flag) & 1;
            if (bit == 1) {
                listA.add(A[i]);
            } else {
                listB.add(A[i]);
            }
        }

        tmp = 0;
        for (Integer integer : listA) {
            tmp = tmp ^ integer;
        }
        list.add(tmp);

        tmp = 0;
        for (Integer integer : listB) {
            tmp = tmp ^ integer;
        }
        list.add(tmp);
        return list;
    }

    public static void main(String[] args) {
        LintCode084 lintCode084 = new LintCode084();
        int[] ints = {1, 2, 2, 3, 4, 4, 5, 3};
        List<Integer> ss = lintCode084.singleNumberIII(ints);
        P.pln(ss);
    }
}
