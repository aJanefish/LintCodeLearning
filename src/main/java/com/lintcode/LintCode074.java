package com.lintcode;

import com.utils.P;

public class LintCode074 {
    private static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return k >= 2147483647;
        }
    }

    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     * 您的提交打败了 75.60% 的提交!
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        long start = 1;
        long end = n;
        int mid = (int)((start + end) / 2);
        if (n == 1) {
            if (SVNRepo.isBadVersion(1)) {
                return n;
            }
        }


        boolean flag_start = false;
        boolean flag_mid = false;
        boolean flag_end = false;

        while (true) {

            P.pln(start + " - " + mid + " - " + end);
            if (start == mid) {
                break;
            }
            if (SVNRepo.isBadVersion(mid)) {//[start,mid]
                end = (long)mid;
                mid = (int)((start + end) / 2);
                flag_end = true;
            } else {//[mid,end]
                flag_start = false;
                start =(long) mid;
                mid = (int)((start + end) / 2);
            }
        }

        if (SVNRepo.isBadVersion((int)start)) return (int)start;
        return (int)end;
    }

    private boolean isBadVersion(int n) {
        return false;
    }

    public static void main(String[] args) {
        LintCode074 lintCode074 = new LintCode074();
        //n = 2147483647 , first bad version is 2147483647
        int x = lintCode074.findFirstBadVersion(2147483647);
        P.pln(x);
    }
}
