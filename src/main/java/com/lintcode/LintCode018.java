package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集。
 * <p>
 * 子集中的每个元素都是非降序的
 * 两个子集间的顺序是无关紧要的
 * 解集中不能包含重复子集
 * <p>
 * 你可以同时用递归与非递归的方式解决么？
 */

public class LintCode018 {

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * 您的提交打败了 17.80% 的提交!
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);


        for (int i = 0; i <= nums.length; i++) {
            subsetsWithDup(lists, list, nums, 0, i, 0);
        }
        return lists;
    }

    private void subsetsWithDup(List<List<Integer>> lists, List<Integer> list, int[] nums, int depth, int target, int start) {
        if (depth == target) {
            lists.add(list);
            return;
        }

        //
        for (int i = start; i < nums.length; i++) {
            if (i == 0) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                tmp.add(nums[i]);
                subsetsWithDup(lists, tmp, nums, depth + 1, target, i + 1);
            } else {
                if (i > start) {
                    if (nums[i] != nums[i - 1]) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                        tmp.add(nums[i]);
                        subsetsWithDup(lists, tmp, nums, depth + 1, target, i + 1);
                    }
                } else {
                    ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(nums[i]);
                    subsetsWithDup(lists, tmp, nums, depth + 1, target, i + 1);
                }
            }
        }
    }


    static class Date018 {
        ArrayList<Integer> list;
        int depth;
        int target;
        int start;

        public Date018(ArrayList<Integer> list, int depth, int target, int start) {
            this.list = list;
            this.depth = depth;
            this.target = target;
            this.start = start;
        }
    }


    //非递归 栈
    //您的提交打败了 29.40% 的提交!
    public List<List<Integer>> subsetsWithDup_two(int[] nums) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        List<Date018> list_flag = new ArrayList<Date018>();
        for (int i = 0; i <= nums.length; i++) {
            //subsets(lists, list, nums, 0, i, 0);
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            list_flag.add(new Date018(tmp, 0, i, 0));
        }

        while (list_flag.size() != 0) {
            Date018 date017 = list_flag.remove(0);
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
                if (i == 0) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>(date017.list);
                    tmp.add(nums[i]);
                    list_flag.add(new Date018(tmp, date017.depth + 1, date017.target, i + 1));
                } else {
                    if (i > date017.start) {
                        if (nums[i] != nums[i - 1]){
                            ArrayList<Integer> tmp = new ArrayList<Integer>(date017.list);
                            tmp.add(nums[i]);
                            list_flag.add(new Date018(tmp, date017.depth + 1, date017.target, i + 1));
                        }
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>(date017.list);
                        tmp.add(nums[i]);
                        list_flag.add(new Date018(tmp, date017.depth + 1, date017.target, i + 1));
                    }
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        LintCode018 lintCode017 = new LintCode018();
        //[1,2,3]
        int[] ints = {1, 2, 2};
        List<List<Integer>> ss = lintCode017.subsetsWithDup(ints);
        P.pln(ss);

        ss = lintCode017.subsetsWithDup_two(ints);
        P.pln(ss);
    }
}
