package com.goo.test.DynamicProgramming;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class changeII {

    @Test
    public void test(){
        int[] coins = {1,2,2,5};
        int amount = 5;
//        System.out.println(change(amount,coins));
        System.out.println(new Date());

        System.out.println(Calendar.getInstance().getTime().getMonth());

    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        // 只有一种硬币的情况
        for (int i = 0; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 第i种硬币使用0~k次，求和
                for (int k = 0; k * coins[i] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

}
