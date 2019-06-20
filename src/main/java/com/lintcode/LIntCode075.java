package com.lintcode;

import com.utils.P;

/**
 * 你给出一个整数数组(size为n)，其具有以下特点：
 * <p>
 * 相邻位置的数字是不同的
 * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 */
public class LIntCode075 {

    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     * 您的提交打败了 99.80% 的提交!
     */
    public int findPeak(int[] A) {
        // write your code here
        int length = A.length;
        if (A[length - 3] < A[length - 2]) {
            return length - 2;
        }
        if (A[1] > A[2]) {
            return 1;
        }

        int start = 0;
        int end = A.length;
        int mid = (start + end) / 2;

        while (true) {
            P.pln(start + " - " + mid + " - " + end);

            if (A[mid] > A[mid + 1] && A[mid - 1] > A[mid]) {//下降 峰值在 [start,mid]
                end = mid;
                mid = (start + end) / 2;
            } else if (A[mid] < A[mid + 1] && A[mid - 1] < A[mid]) { //上升 峰值在 [mid,end]
                start = mid;
                mid = (start + end) / 2;
            } else if (A[mid] > A[mid + 1] && A[mid - 1] < A[mid]) {
                return mid;
            } else {
                //mid 是极小值
                start = mid;
                mid = (start + end) / 2;
            }

        }
        //return 0;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 1, 3, 4, 5, 7, 6};
        LIntCode075 lIntCode075 = new LIntCode075();
        int ss = lIntCode075.findPeak(x);
        P.pln(ss);
    }
}
