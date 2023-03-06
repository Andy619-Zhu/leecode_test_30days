package com.goo.test.DynamicProgramming;

import org.junit.Test;

/**
 * 70
 *
 * @author Lenovo
 */
public class ClimbingStairs {
    @Test
    public void test() {
        System.out.println(climbStairs(5));
    }
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
