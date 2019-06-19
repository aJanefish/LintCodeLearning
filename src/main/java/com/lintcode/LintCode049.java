package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
 * <p>
 * 挑战
 * 在原地扫描一遍完成
 * <p>
 * <p>
 * 样例 1:
 * 输入:  "abAcD"
 * 输出:  "acbAD"
 */
public class LintCode049 {

    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     * 您的提交打败了 31.60% 的提交!
     *
     */

    //abAcD
    //'A' = 65
    //'Z' = 90
    //'a' = 97
    //'z' = 122
    public void sortLetters(char[] chars) {
        // write your code here
        for (int i = 1; i < chars.length; i++) {
            char ch = chars[i];
            int ch_index = (int) ch;
            int i1 = i - 1;
            for (; i1 >= 0; i1--) {
                //if ()
                int tmp = (int) chars[i1];
                if (ch_index >= 97 && tmp >= 97) {//都是小写字母
                    if (tmp > ch_index) {
                        chars[i1 + 1] = chars[i1];
                    } else {
                        break;
                    }

                } else if (ch_index <= 90 && tmp <= 90) {//都是大写字母
                    if (tmp > ch_index) {
                        chars[i1 + 1] = chars[i1];
                    } else {
                        break;
                    }
                } else {
                    if (tmp <= 90) {
                        chars[i1 + 1] = chars[i1];
                    } else {
                        break;
                    }
                }
            }
            chars[i1 + 1] = ch;
        }
    }

    public static void main(String[] args) {
        LintCode049 lintCode049 = new LintCode049();
        char[] chars = "abAcD".toCharArray();
        P.pln(Arrays.toString(chars));
        lintCode049.sortLetters(chars);
        P.pln(Arrays.toString(chars));

        P.pln((int) 'Z');
        P.pln((int) 'a');
    }
}
