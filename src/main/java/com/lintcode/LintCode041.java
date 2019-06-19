package com.lintcode;

import com.utils.P;

import java.util.Arrays;

/**
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 * 输入：[−2,2,−3,4,−1,2,1,−5,3]
 * 输出：6
 * 解释：符合要求的子数组为[4,−1,2,1]，其最大和为 6。
 */

public class LintCode041 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * 您的提交打败了 98.20% 的提交!
     */
    public int maxSubArray(int[] nums) {
        // write your code here

        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean has = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                has = true;
            }
            if (i == 0) {
                max = nums[i];
                sum += nums[i];
                continue;
            }

            if (sum < 0 && nums[i] >= 0) {
                sum = nums[i];
            } else if (sum < 0 && nums[i] < 0) {
                sum = sum > nums[i] ? sum : nums[i];
            } else {
                sum += nums[i];
            }

            if (has && sum <= 0) sum = 0;

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }


    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     *
     * 思路：一直 A[0..i]的最大子数组
     * 求A[0..i,i+1]的最大子数组
     *
     * 您的提交打败了 13.20% 的提交!
     *
     */
    public int maxSubArray_two(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE;
        int tmp_max = Integer.MIN_VALUE;
        int tmp_sum = 0;
        int low = 0;
        int high = 0;

        int tmp_low = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = nums[i];
                low = high = i;
                continue;
            }

            if (nums[i] >= 0) {
                if (max <= 0) {
                    max = nums[i];
                    low = high = i;
                } else {
                    if (high == (i - 1)) {
                        max = max + nums[i];
                        high = i;
                    } else {
                        for (int i1 = i; i1 >= 0; i1--) {
                            tmp_sum += nums[i1];
                            if (tmp_max < tmp_sum) {
                                tmp_max = tmp_sum;
                                tmp_low = i1;
                            }
                        }

                        tmp_sum = 0;

                        if (tmp_max > max) {
                            max = tmp_max;
                            high = i;
                            low = tmp_low;
                        }
                        tmp_max = Integer.MIN_VALUE;
                    }
                }
            } else {//sum[i]<0
                if (max >= 0) {
                    continue;
                } else {//max < 0
                    if (nums[i] > max) {
                        max = nums[i];
                        high = i;
                        low = i;
                    }
                }
            }
        }
        return max;
    }

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * 您的提交打败了 77.80% 的提交!
     */
    public int maxSubArray_three(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE;
        int[] falg = new int[3];
        fm(nums, 0, nums.length - 1, falg);
        //P.pln("maxSubArray_three:" + Arrays.toString(falg));
        return falg[2];
    }

    private void fm(int[] nums, int low, int high, int[] flag) {
        if (low == high) {
            flag[0] = low;
            flag[1] = low;
            flag[2] = nums[low];
            return;
        }

        int mid = (low + high) / 2;
        int[] flag_low = new int[3];
        fm(nums, low, mid, flag_low);

        int[] flag_high = new int[3];
        fm(nums, mid + 1, high, flag_high);

        int[] flag_cross = new int[3];
        fmc(nums, low, mid, high, flag_cross);

        if (flag_low[2] >= flag_high[2] && flag_low[2] >= flag_cross[2]) {
            flag[0] = flag_low[0];
            flag[1] = flag_low[1];
            flag[2] = flag_low[2];
        } else if (flag_high[2] >= flag_low[2] && flag_high[2] >= flag_cross[2]) {
            flag[0] = flag_high[0];
            flag[1] = flag_high[1];
            flag[2] = flag_high[2];
        } else {
            flag[0] = flag_cross[0];
            flag[1] = flag_cross[1];
            flag[2] = flag_cross[2];
        }


    }

    private void fmc(int[] nums, int low, int mid, int high, int[] flag) {
        //[low,mid] [mid+1,high]
        int low_index = 0;
        int low_max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            if (sum > low_max) {
                low_max = sum;
                low_index = i;
            }
        }

        int high_max = Integer.MIN_VALUE;
        int high_index = 0;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            if (sum > high_max) {
                high_max = sum;
                high_index = i;
            }
        }
        flag[0] = low_index;
        flag[1] = high_index;
        flag[2] = low_max + high_max;

    }


    public static void main(String[] args) {
        LintCode041 lintCode041 = new LintCode041();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 100, 200, 1000};
        int sf = lintCode041.maxSubArray(nums);
        P.pln(sf);

        int sf1 = lintCode041.maxSubArray_two(nums);
        P.pln(sf1);

        int max_three = lintCode041.maxSubArray_three(nums);
        P.pln(max_three);
    }


}
