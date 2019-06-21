package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个含不同整数的集合，返回其所有的子集。
 * <p>
 * 你可以同时用递归与非递归的方式解决么？
 */

public class LintCode017 {

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     * <p>
     * 您的提交打败了 51.40% 的提交!
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        java.util.Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            subsets(lists, list, nums, 0, i, 0);
        }
        return lists;
    }

    private void subsets(List<List<Integer>> lists, List<Integer> list, int[] nums, int depth, int target, int start) {
        if (depth == target) {
            lists.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(list);
            tmp.add(nums[i]);
            subsets(lists, tmp, nums, depth + 1, target, i + 1);
        }
    }


    static class Date017 {
        ArrayList<Integer> list;
        int depth;
        int target;
        int start;

        public Date017(ArrayList<Integer> list, int depth, int target, int start) {
            this.list = list;
            this.depth = depth;
            this.target = target;
            this.start = start;
        }
    }


    //非递归 栈
    //您的提交打败了 22.60% 的提交!
    public List<List<Integer>> subsets_two(int[] nums) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        java.util.Arrays.sort(nums);

        List<Date017> list_flag = new ArrayList<Date017>();
        for (int i = 0; i <= nums.length; i++) {
            //subsets(lists, list, nums, 0, i, 0);
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            list_flag.add(new Date017(tmp, 0, i, 0));
        }

        while (list_flag.size() != 0) {
            Date017 date017 = list_flag.remove(0);
            //        if (depth == target) {
            //            lists.add(list);
            //            return;
            //        }
            //
            //        for (int i = start; i < nums.length; i++) {
            //            ArrayList<Integer> tmp = new ArrayList<Integer>(list);
            //            tmp.add(nums[i]);
            //            subsets(lists, tmp, nums, depth + 1, target, i + 1);
            //        }

            if (date017.depth == date017.target) {
                lists.add(date017.list);
                continue;
            }

            for (int i = date017.start; i < nums.length; i++) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(date017.list);
                tmp.add(nums[i]);
                //subsets(lists, tmp, nums, date017.depth + 1, date017.target, i + 1);
                list_flag.add(new Date017(tmp, date017.depth + 1, date017.target, i + 1));
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        LintCode017 lintCode017 = new LintCode017();
        //[1,2,3]
        int[] ints = {4, 1, 0};
        List<List<Integer>> ss = lintCode017.subsets(ints);
        P.pln(ss);

        ss = lintCode017.subsets_two(ints);
        P.pln(ss);
    }
}
