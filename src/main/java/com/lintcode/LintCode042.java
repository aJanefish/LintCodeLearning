package com.lintcode;

import com.utils.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 * <p>
 * <p>
 * 思路  划分我两个数组
 */
public class LintCode042 {


    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */


    public int maxTwoSubArrays(final List<Integer> nums) {
        // write your code here
        //step one
        //划分为两个数组
        int max = Integer.MIN_VALUE;
//        ExecutorService service = Executors.newCachedThreadPool();
//        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for (int i = 1; i <= nums.size() - 1; i++) {
            //[0,i][i+1,nums.size-1]

            int tmp_max = maxSubArray(nums,0,i) + maxSubArray(nums,i,nums.size());
            if (tmp_max > max) {
                max = tmp_max;
            }


//            final int finalI = i;
//            list.add(service.submit(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    int tmp_max = maxSubArray(nums, 0, finalI) + maxSubArray(nums, finalI, nums.size());
//                    return tmp_max;
//                }
//            }));
        }
//        service.shutdown();
//        try {
//            for (Future<Integer> future : list) {
//                int tmp = 0;
//
//                tmp = future.get();
//
//                if (tmp > max) {
//                    max = tmp;
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        return max;
    }
    /**
     * @param list : A list of integers
     */
    private int maxSubArray(List<Integer> list, int start, int end) {
        // write your code here
        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean has = false;

        for (int i = start; i < end; i++) {
            int value = list.get(i);
            if (value >= 0) {
                has = true;
            }
            if (i == start) {
                max = value;
                sum += value;

                continue;
            }

            if (sum < 0 && value >= 0) {
                sum = value;
            } else if (sum < 0 && value < 0) {
                if (value > sum) {
                    sum = value;
                }
            } else {
                sum += value;
            }

            if (has && sum <= 0) {
                sum = 0;
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LintCode042 lintCode042 = new LintCode042();
        List<Integer> list = new ArrayList<Integer>();
        //[1, 3, -1, 2, -1, 2]
        list.add(1);
        list.add(3);
        list.add(-1);
        list.add(2);
        list.add(-1);
        list.add(2);


        P.pln(list);
        int max = lintCode042.maxTwoSubArrays(list);
        P.pln(max);


    }
}
