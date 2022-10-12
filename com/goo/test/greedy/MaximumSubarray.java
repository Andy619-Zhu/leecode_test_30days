package com.goo.test.greedy;

import org.junit.Test;

/**
 * 53
 *
 * @author
 */
public class MaximumSubarray {
    @Test
    public void test() {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; //6
//        int[] nums = {0};//0
//        int[] nums = {-1};//-1
        int[] nums = {-2,-1};//-1
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int preResult = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if (num > sum) {
                sum = num;
            }
            if (sum > preResult) {
                preResult = sum;
            }
            if (result < preResult) {
                result = preResult;
            }
        }
        return result;
    }
}
