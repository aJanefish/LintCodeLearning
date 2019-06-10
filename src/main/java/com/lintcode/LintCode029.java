package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 * <p>
 * 输入:
 * "aabcc"
 * "dbbca"
 * "aadbbcbcac"
 * 输出:
 * true
 */
public class LintCode029 {

    static class Cache {
        int index_s1;
        int index_s2;
        int index_s3;

        public Cache(int index_s1, int index_s2, int index_s3) {
            this.index_s1 = index_s1;
            this.index_s2 = index_s2;
            this.index_s3 = index_s3;
        }
    }

    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int length_s3 = s3.length();
        int length_s1 = s1.length();
        int length_s2 = s2.length();
        if ((length_s1 + length_s2) != length_s3) {
            return false;
        }

        int index_s1 = 0;
        int index_s2 = 0;
        int index_s3;

        List<Cache> list = new ArrayList<Cache>();
        for (index_s3 = 0; index_s3 < length_s3; ) {
            char ch3 = s3.charAt(index_s3);

            if (index_s1 < length_s1 && index_s2 < length_s2) {
                if (s1.charAt(index_s1) == ch3 && s2.charAt(index_s2) == ch3) {
                    //保存状态，准备回溯
                    Cache cache = new Cache(index_s1, index_s2, index_s3);
                    list.add(cache);
                    //走A
                    index_s1++;
                    index_s3++;

                } else if (s1.charAt(index_s1) == ch3 && s2.charAt(index_s2) != ch3) {
                    index_s1++;
                    index_s3++;
                } else if (s2.charAt(index_s2) == ch3 && s1.charAt(index_s1) != ch3) {
                    index_s2++;
                    index_s3++;
                } else {
                    if (list.size() == 0) {//没有回溯点
                        return false;
                    }
                    Cache cache = list.remove(0);
                    index_s1 = cache.index_s1;
                    index_s2 = cache.index_s2;
                    index_s3 = cache.index_s3;

                    index_s2++;
                    index_s3++;
                }
            } else if (index_s1 < length_s1 && index_s2 == length_s2) {
                if (s1.charAt(index_s1) == ch3) {
                    index_s1++;
                    index_s3++;
                } else {
                    if (list.size() == 0) {//没有回溯点
                        return false;
                    }
                    Cache cache = list.remove(0);
                    index_s1 = cache.index_s1;
                    index_s2 = cache.index_s2;
                    index_s3 = cache.index_s3;

                    index_s2++;
                    index_s3++;
                }
            } else {
                if (s2.charAt(index_s2) == ch3) {
                    index_s2++;
                    index_s3++;
                } else {
                    if (list.size() == 0) {//没有回溯点
                        return false;
                    }
                    Cache cache = list.remove(0);
                    index_s1 = cache.index_s1;
                    index_s2 = cache.index_s2;
                    index_s3 = cache.index_s3;

                    index_s2++;
                    index_s3++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        LintCode029 lintCode029 = new LintCode029();
        String a = "aabcc";
        String b = "dbbca";
        String c = "aadbbcbcac";
        boolean ss = lintCode029.isInterleave(a, b, c);
        P.pln(ss);
    }
}
