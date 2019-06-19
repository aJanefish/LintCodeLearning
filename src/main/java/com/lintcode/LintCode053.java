package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */

public class LintCode053 {
    //输入:  "the sky is blue"
//	输出:  "blue is sky the
    /*
     * @param s: A string
     * @return: A string
     *
     * 您的提交打败了 70.80% 的提交!
     */
    public String reverseWords(String s) {
        // write your code here
        String s1 = s.trim();
        String[] ss = s1.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            String value = ss[i].trim();
            if (value.length() != 0) {
                stringBuilder.append(value);
                if (i != 0) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 提高难度
     * 只在自己的String 内部翻转
     */
    public String reverseWords_two(String s) {
        // write your code here
        String s1 = s.trim();
        String[] ss = s1.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            String value = ss[i].trim();
            if (value.length() != 0) {
                stringBuilder.append(value);
                if (i != 0) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {

        LintCode053 lintCode053 = new LintCode053();
        String asdsafd = "the  sky  is  blue";
        P.pln(asdsafd);
        String ss = lintCode053.reverseWords(asdsafd);
        P.pln(ss);

        String sssg = asdsafd.replace(" ", ".");
        P.pln(sssg);
        sssg = ss.replace(".", " ");
        P.pln(sssg);
    }
}
