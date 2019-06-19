package com.lintcode;

import com.utils.P;

/**
 * 实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。如果整数超出了32位整数的范围，返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数。
 */

public class LintCode054 {

    /**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        int parseInt = Integer.parseInt(str);
        return parseInt;
    }

    public static void main(String[] args) {
        //123123123123123
        LintCode054 lintCode054 = new LintCode054();
        int ss = lintCode054.atoi("1.0");
        P.pln(ss);
    }
}
