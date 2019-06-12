package com.lintcode;

import com.utils.P;

/**
 * 反转一个只有3位数的整数
 */

public class LintCode037 {

    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        if (number % 100 == 0) {
            return number / 100;
        } else if (number % 10 == 0) {
            //250
            return number / 100 + (number % 100);
        }
        //123
        return number % 10 * 100 + number / 100 + (number % 100 / 10) * 10;
    }

    public static void main(String[] args) {
        LintCode037 lintCode037 = new LintCode037();
        int ss = lintCode037.reverseInteger(123);
        P.pln(ss);
    }
}
