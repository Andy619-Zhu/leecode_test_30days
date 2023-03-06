package com.goo.test.DynamicProgramming;

import org.junit.Test;

/**
 * 509
 * @author Lenovo
 */
public class FibonacciNumber {
    @Test
    public void test() {
        System.out.println(fib(10));
    }
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n +1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
