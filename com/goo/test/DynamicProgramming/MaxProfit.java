package com.goo.test.DynamicProgramming;

import org.junit.Test;


public class MaxProfit {
    @Test
    public void test(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices){
        int[][] dp = new int[prices.length][2];
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return dp[prices.length-1][1];
    }
}
