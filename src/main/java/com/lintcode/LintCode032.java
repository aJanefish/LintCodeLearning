package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的最短子串。
 * <p>
 * 如果在source中没有这样的子串，返回""。
 * 如果有多个这样的子串，保证在source中始终只有一个唯一的最短子串。
 * 目标字符串可能包含重复字符，最小窗口应覆盖所有字符，包括目标中的重复字符
 */

public class LintCode032 {

    /**
     * @param source  : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {

        // write your code here
        int length_target = target.length();
        int length_source = source.length();
        if (length_source == 0) {
            return "";
        }


        for (int lenght_substring = length_target; lenght_substring <= length_source; lenght_substring++) {
            for (int i = 0; i < length_source - lenght_substring + 1; i++) {
                String sub = source.substring(i, i + lenght_substring);
                //P.pln(sub);
                if (contain(sub, target)) {
                    return sub;
                }
            }
        }
        return "";
    }

    private boolean contain(String sub, String target) {
        boolean[] booleans = new boolean[target.length()];
        int tmp = 0;
        for (int i = 0; i < sub.length(); i++) {
            char ch_sub = sub.charAt(i);
            for (int i1 = 0; i1 < target.length(); i1++) {
                char ch_target = target.charAt(i1);
                //P.pln(ch_target);
                if (ch_sub == ch_target && !booleans[i1]) {
                    booleans[i1] = true;
                    tmp++;
                    break;
                }
            }
        }

        P.pln(sub + " - " + target+" - "+tmp+" - "+ Arrays.toString(booleans));
        return tmp == target.length();
    }


    public static void main(String[] args) {

        LintCode032 lintCode032 = new LintCode032();
        //输入:
        //"ADOBECODEBANC"
        //"ABC"
        //输出:
        //"BANC"

        String soutce = "abcdecf";
        String target = "acc";
        P.pln(soutce);
        P.pln(target);
        String result = lintCode032.minWindow(soutce, target);
        P.pln(result);

    }
}
