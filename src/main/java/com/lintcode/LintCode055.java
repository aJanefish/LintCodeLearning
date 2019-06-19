package com.lintcode;

import com.utils.P;

/**
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 */

public class LintCode055 {

    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     *
     * 您的提交打败了 98.20% 的提交!
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        int nums = 0;
        boolean[] flag = new boolean[B.length()];
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            for (int i1 = 0; i1 < B.length(); i1++) {

                if (!flag[i1] && B.charAt(i1) == ch) {
                    flag[i1] = true;
                    nums++;
                    break;
                }

            }
        }
        if (B.length() == nums) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LintCode055 lintCode055 = new LintCode055();
        boolean ss = lintCode055.compareStrings("ABCD", "ABCE");
        P.pln(ss);
    }
}
