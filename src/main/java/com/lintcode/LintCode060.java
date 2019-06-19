package com.lintcode;

import com.utils.P;

/**
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 * <p>
 * 你可以假设在数组中无重复元素。
 */

public class LintCode060 {

    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     *
     * 您的提交打败了 88.80% 的提交!
     *
     * 使用二分法
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        int start = 0;
        int end = A.length;
        if (end == 0) {
            return 0;
        }
        if (target < A[0]) return 0;
        if (target > A[end - 1]) return end;
        int mid = (start + end) / 2;
        while (true) {
            if (A[mid] == target)
                return mid;

            P.pln(start + " - " + mid + " - " + end);
            if (start == mid) {
                if (A[start] < target && A[end] > target) {
                    return end;
                } else {
                    return start;
                }
            }

            if (A[mid] < target) {
                start = mid;
                mid = (start + end) / 2;
            } else {
                end = mid;
                mid = (start + end) / 2;
            }

        }
    }

    public static void main(String[] args) {
        LintCode060 lintCode060 = new LintCode060();
        //[1,3,5,6]，2 → 1
        int[] ints = {1, 10, 201, 1001, 10001, 10007};
        int index = lintCode060.searchInsert(ints, 10008);
        P.pln(index);
    }
}
