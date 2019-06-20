package com.lintcode;

import com.utils.P;

/**
 * 给k个字符串，求出他们的最长公共前缀(LCP)
 */
public class LintCode078 {

    //您的提交打败了 73.80% 的提交!
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int tmp = strs[i].length();
            if (tmp < min) {
                min = tmp;
            }
        }

        int length = strs.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char ch = strs[0].charAt(i);
            for (int index = 1; index < length; index++) {
                String tmp = strs[index];
                char tm = tmp.charAt(i);
                if (tm != ch) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(""+ch);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LintCode078 lintCode078 = new LintCode078();
        String[] strings = {"A", "A"};
        String ss = lintCode078.longestCommonPrefix(strings);
        P.pln(ss);
    }
}
