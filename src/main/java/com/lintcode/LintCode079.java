package com.lintcode;

import com.utils.P;

/**
 * 给出两个字符串，找到最长公共子串，并返回其长度
 * <p>
 * DP 动态规划
 */
public class LintCode079 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     * <p>
     * 您的提交打败了 100.00% 的提交!
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A.length() == 0 || B.length() == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int[][] flag = new int[B.length()][A.length()];
        for (int b = 0; b < B.length(); b++) {
            for (int a = 0; a < A.length(); a++) {
                if (A.charAt(a) == B.charAt(b)) {
                    //flag[b-1][a-1]+1
                    if (b > 0 && a > 0) {
                        flag[b][a] = flag[b - 1][a - 1] + 1;
                    } else {
                        flag[b][a] = 1;
                    }
                } else {
                    // max(flag[b-1][a],flag[b][a-1]);
                    flag[b][a] = 0;
                }
                if (max < flag[b][a]) {
                    max = flag[b][a];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LintCode079 lintCode079 = new LintCode079();
        int nums = lintCode079.longestCommonSubstring("ABCD", "CBCE");
        P.pln(nums);

    }
}
