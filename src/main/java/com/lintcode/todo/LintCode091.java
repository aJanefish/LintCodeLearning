package com.lintcode.todo;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class LintCode091 {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public static int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        //[A+1][101]
        int length = A.size() + 1;
        int[][] flag = new int[length][101];
        for (int i = 0; i <= 100; i++) {
            flag[0][i] = 0;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= 100; j++) {
                flag[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= 100; j++) { //将要变化的位置的目标值
                //[j-target,j+target]
                if (flag[i - 1][j] != Integer.MAX_VALUE) {
                    if (j - target >= 0 && j + target <= 100) {

                        for (int k = j - target; k <= j + target; k++) {
                            if (Math.abs(j - k) <= target) {
                                if (flag[i][j] > flag[i - 1][k] + Math.abs(A.get(i - 1) - j)) {
                                    flag[i][j] = flag[i - 1][k] + Math.abs(A.get(i - 1) - j);
                                }
                            }
                        }

                    } else {
                        for (int k = 0; k < 100; k++) {
                            if (Math.abs(j - k) <= target) {

                                if (flag[i][j] > flag[i - 1][k] + Math.abs(A.get(i - 1) - j)) {
                                    flag[i][j] = flag[i - 1][k] + Math.abs(A.get(i - 1) - j);
                                }
                            }
                        }
                    }
                }
            }
        }

        show(length, flag);

        //找到最小值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            if (min > flag[length - 1][i]) {
                min = flag[length - 1][i];
            }
        }
        return min;
    }

    private static void show(int length, int[][] flag) {
        for (int i = 0; i <= 100; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i <= 100; i++) {
            System.out.print("--");
        }
        System.out.println();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= 100; j++) {
                System.out.print(flag[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);

        System.out.println(MinAdjustmentCost(list, 1));
    }
}
