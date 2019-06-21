package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定n个不同的正整数，整数k（1<= k <= n）以及一个目标数字。　　　　
 *
 * 在这n个数里面找出K个数，使得这K个数的和等于目标数字，你需要找出所有满足要求的方案
 */
public class LintCode090 {

    //DFS 深度优先算法
    //超时 不是最优解
    public List<List<Integer>> kSumII(int[] A, int k, int target) {


        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        kSum_two_d(lists, list, A, k, target, 0);
        P.pln(lists);
        return lists;
    }

    private void kSum_two_d(List<List<Integer>> lists, List<Integer> list, int[] arr, int k, int target, int index) {
        if (list.size() == k && target == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target) continue;
            list.add(arr[i]);
            kSum_two_d(lists, list, arr, k, target - arr[i], i + 1);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        LintCode090 lintCode089 = new LintCode090();
        int[] ints = {1, 2, 3, 4, 5, 6};


        List<List<Integer>> ss = lintCode089.kSumII(ints, 2, 7);
        P.pln(ss);
    }
}
