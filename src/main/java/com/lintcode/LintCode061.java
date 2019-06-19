package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 * <p>
 * 如果目标值不在数组中，则返回[-1, -1]
 */
public class LintCode061 {

    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     *
     * 您的提交打败了 84.00% 的提交!
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here

        int end = A.length;
        int[] reslut = new int[2];
        if (end == 0) {
            reslut[0] = -1;
            reslut[1] = -1;
            return reslut;
        }

        if (A[0] > target || A[end - 1] < target) {
            reslut[0] = -1;
            reslut[1] = -1;
            return reslut;
        }
        int start = 0;

        int mid = (start + end) / 2;
        while (true) {
            P.pln(start + " - " + mid + " - " + end);
            if (A[mid] == target) {
                for (int i = mid; i >= 0; i--) {
                    if (A[i] == target) {
                        reslut[0] = i;
                        continue;
                    }
                    break;
                }

                for (int i = mid; i < A.length; i++) {
                    if (A[i] == target) {
                        reslut[1] = i;
                        continue;
                    }
                    break;
                }
                P.pln(Arrays.toString(reslut));
                return reslut;
            }


            if (start == mid) {
                if (A[end] == target) {
                    for (int i = end; i >= 0; i--) {
                        if (A[i] == target) {
                            reslut[0] = i;
                            continue;
                        }
                        break;
                    }

                    for (int i = end; i < A.length; i++) {
                        if (A[i] == target) {
                            reslut[1] = i;
                            continue;
                        }
                        break;
                    }
                    return reslut;
                } else {
                    reslut[0] = -1;
                    reslut[1] = -1;
                    return reslut;
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
        LintCode061 lintCode061 = new LintCode061();
        //[5, 7, 7, 8, 8, 10]
        //8
        int[] ints = {9,10,100,101,1002,10203};
        int[] ss = lintCode061.searchRange(ints, 10203);
        P.pln(Arrays.toString(ss));
    }
}
