package com.goo.test.DynamicProgramming;

import java.util.Arrays;

/**
 * 416
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }

    /**
     * dp[j] 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]
     * @param nums
     * @return
     */

    public static boolean canPartition(int[] nums){
        if(nums == null || nums.length == 0) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum%2!=0){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[sum/2 + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[dp.length-1]==sum/2;
    }


}
