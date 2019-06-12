package com.lintcode;

import com.utils.P;

/**
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 * <p>
 * 这个矩阵具有以下特性：
 * <p>
 * 每行中的整数从左到右是排序的。
 * 每一列的整数从上到下是排序的。
 * 在每一行或每一列中没有重复的整数。
 */
public class LintCode038 {

    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int y = matrix.length;
        if (y == 1) {
            int[] ma = matrix[0];
            for (int i = 0; i < ma.length; i++) {
                if (ma[i] > target) {
                    return 0;
                }

                if (ma[i] == target) {
                    return 1;
                }
            }
            return 0;
        }

        int sum = 0;
        int x_limit = Integer.MAX_VALUE;
        for (int i = 0; i < y; i++) {
            int[] ma = matrix[i];
            if (ma[0] > target) {
                break;
            }
            for (int x = 0; x < ma.length && x < x_limit; x++) {
                if (ma[x] > target) {
                    x_limit = x;
                    break;
                }

                if (ma[x] == target) {
                    sum++;
                    x_limit = x;
                    break;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        LintCode038 lintCode038 = new LintCode038();
        int[][] mat = {
                {1, 3, 5, 7},
                {2, 4, 7, 8},
                {3, 5, 9, 10}
        };
        int total = lintCode038.searchMatrix(mat, 3);
        P.pln(total);
    }
}
