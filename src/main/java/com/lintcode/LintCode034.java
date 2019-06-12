package com.lintcode;
/**
 * 根据n皇后问题，现在返回n皇后不同的解决方案的数量而不是具体的放置布局。
 * */

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

public class LintCode034 {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        // write your code here
        List<Integer> lists = new ArrayList<Integer>();
        if (n == 1) {
            return 1;
        }

        //找出皇后问题

        int[][] quenuFlag = new int[n][n];//记录
        //递归调用皇后问题
        solveNQueens(0, quenuFlag, lists);

        return lists.size();
    }


    private void solveNQueens(int depth, int[][] flag, List<Integer> lists) {
        if (depth == flag.length) {
            //根据Flag得到String
            //flagToString(flag, lists);
            lists.add(depth);
            return;
        }

        for (int i = 0; i < flag.length; i++) {
            //P.pln(depth + " - " + lists.size());
            if (flag[depth][i] > 0) {
                continue;
            }
            int[][] new_flag = copyQuenuFlag(flag);
            domain(new_flag, depth, i);
            solveNQueens(depth + 1, new_flag, lists);
        }
    }

    private void flagToString(int[][] new_flag, List<List<String>> lists) {
        StringBuilder stringBuilder;
        List<String> list = new ArrayList<String>();
        for (int y = 0; y < new_flag.length; y++) {
            stringBuilder = new StringBuilder();
            for (int x = 0; x < new_flag.length; x++) {
                if (new_flag[y][x] == 2) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            list.add(stringBuilder.toString());
        }
        lists.add(list);
    }


    //设置领土权
    private void domain(int[][] flag, int y, int x) {
        int length = flag.length;
        for (int i = 0; i < length; i++) {
            flag[y][i] = 1;
            flag[i][x] = 1;
        }

        int tmpx = x - 1;
        int tmpy = y - 1;
        while (tmpx >= 0 && tmpy >= 0) {
            flag[tmpy--][tmpx--] = 1;
        }

        tmpx = x + 1;
        tmpy = y + 1;
        while (tmpx < length && tmpy < length) {
            flag[tmpy++][tmpx++] = 1;
        }

        tmpx = x + 1;
        tmpy = y - 1;
        while (tmpx < length && tmpy >= 0) {
            flag[tmpy--][tmpx++] = 1;
        }

        tmpx = x - 1;
        tmpy = y + 1;
        while (tmpx >= 0 && tmpy < length) {
            flag[tmpy++][tmpx--] = 1;
        }
        flag[y][x] = 2;
    }

    private int[][] copyQuenuFlag(int[][] flag) {
        int[][] new_flag = new int[flag.length][flag.length];//记录

        for (int i = 0; i < new_flag.length; i++) {
            for (int j = 0; j < new_flag.length; j++) {
                new_flag[i][j] = flag[i][j];
            }
        }
        return new_flag;
    }


    public static void main(String[] args) {
        LintCode034 lintCode034 = new LintCode034();
        int x = lintCode034.totalNQueens(4);
        P.pln(x);
    }
}
