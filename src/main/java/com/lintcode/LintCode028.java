package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/***
 *写出一个高效的算法来搜索 m × n矩阵中的值。
 *
 * 这个矩阵具有以下特性：
 *
 * 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 *
 * 思路：二分查找
 *
 */


public class LintCode028 {

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int heigth = matrix.length;
        if (heigth == 0) {
            return false;
        }
        //P.pln(heigth);
        int width = matrix[0].length;
        if (width == 0) {
            return false;
        }

        //P.pln(width + " - " + heigth);
        // [0,0] - [4,3]

        int min[] = {0, 0};
        int max[] = {width - 1, heigth - 1};
        int mid[] = new int[2];
        mid_cal(min, max, mid, width);


        do {
            int mid_value = matrix[mid[1]][mid[0]];
            int min_value = matrix[min[1]][min[0]];
            int max_value = matrix[max[1]][max[0]];
            //P.pln(min_value);
            if (mid_value == target || min_value == target || max_value == target) {
                return true;
            } else if (mid_value < target) {
                //计算下一个mid点
                // mid max
                min[0] = mid[0];
                min[1] = mid[1];

                mid_cal(min, max, mid, width);


            } else {
                //min mid
                max[0] = mid[0];
                max[1] = mid[1];
                mid_cal(min, max, mid, width);
            }
        } while ((min[1] * width + min[0]) < (max[1] * width + max[0]));

        return false;
    }


    private void mid_cal(int min[], int max[], int mid[], int width) {
        int length = (max[1] - min[1]) * width + max[0] - min[0];
        int mid_values = length / 2;
        if (length == 1) {
            mid[0] = min[0];
            mid[1] = min[1];
            max[0] = min[0];
            max[1] = min[1];
            return;
        }
        //P.pln(length);
        mid[0] = min[0];
        mid[1] = min[1];
        for (int i = 0; i < mid_values; i++) {
            if (mid[0] < width - 1) {
                mid[0] += 1;
            } else {
                mid[0] = 0;
                mid[1] += 1;
            }
        }
        P.pln(Arrays.toString(min) + "-" + Arrays.toString(mid) + "-" + Arrays.toString(max));
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int[][] matrix1 = {
                {}
        };

        int[][] mat3 = {{1, 4, 5}, {6, 7, 8}};

        int[][] mat4 = {{1, 5, 8, 12, 13, 15, 18, 20, 25, 26, 28, 33, 38, 40, 43, 49, 52, 53, 59}, {84, 100, 110, 129, 141, 156, 177, 198, 220, 242, 254, 266, 284, 297, 316, 326, 343, 358, 373}, {388, 398, 419, 439, 449, 460, 472, 495, 516, 539, 560, 582, 600, 610, 624, 643, 668, 691, 710}, {720, 733, 751, 765, 787, 804, 814, 832, 856, 880, 905, 930, 950, 974, 999, 1012, 1022, 1039, 1061}, {1081, 1091, 1102, 1126, 1151, 1175, 1194, 1219, 1239, 1253, 1263, 1274, 1287, 1298, 1308, 1318, 1337, 1361, 1382}, {1404, 1417, 1437, 1452, 1466, 1487, 1503, 1518, 1537, 1555, 1578, 1590, 1601, 1613, 1636, 1659, 1669, 1688, 1712}};


        P.pln(matrix[0][0] + " - " + matrix[2][3]);
        LintCode028 lintCode025 = new LintCode028();
        boolean flag = lintCode025.searchMatrix(matrix, 7);
        P.pln(flag);
    }
}
