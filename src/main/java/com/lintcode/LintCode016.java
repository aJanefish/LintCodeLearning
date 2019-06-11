package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 */
public class LintCode016 {

    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            lists.add(new ArrayList<Integer>());
            return lists;
        }
        boolean[] booleans = new boolean[nums.length];

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) continue;
            hashSet.add(nums[i]);
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            boolean[] copyOf = Arrays.copyOf(booleans, booleans.length);
            copyOf[i] = true;
            permuteUnique(nums, lists, list, copyOf);
        }

        return lists;
    }

    private void permuteUnique(int[] nums, List<List<Integer>> lists, List<Integer> list, boolean[] booleans) {
        if (list.size() == nums.length) {
            lists.add(list);
            return;
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!booleans[i]) {
                if (hashSet.contains(nums[i])) continue;
                hashSet.add(nums[i]);
                boolean[] copyOf = Arrays.copyOf(booleans, booleans.length);
                copyOf[i] = true;
                List<Integer> tmp_List = new ArrayList<Integer>();
                tmp_List.addAll(list);
                tmp_List.add(nums[i]);
                permuteUnique(nums, lists, tmp_List, copyOf);
            }
        }
    }

    public static void main(String[] args) {
        LintCode016 lintCode016 = new LintCode016();
        int[] nums = {1,4,4,5};
        List<List<Integer>> lists = lintCode016.permuteUnique(nums);
        P.pln(lists);
    }
}
