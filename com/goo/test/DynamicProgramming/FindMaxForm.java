package com.goo.test.DynamicProgramming;

import org.junit.Test;

/**
 * 474 一和零
 */
public class FindMaxForm {

    @Test
    public void test(){
        String[] strs = {"10","0001","111001","1","0"};
        int m = 3;
        int n = 3;

        System.out.println(findMaxForm(strs,m,n));
    }

    /**
     * dp[i][j]  0的个数不超过i，1的个数不超过j的情况下，最大子集的个数dp[i][j]
     * dp[1][1]  0的个数不超过1，1的个数不超过1的情况下
     * dp[1][2]  0的个数不超过1，1的个数不超过2的情况下
     * dp[1][3]  0的个数不超过1，1的个数不超过3的情况下
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[] oneCount = new int[strs.length];
        int[] zeroCount = new int[strs.length];
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') zeroCount[i]++;
                if (strs[i].charAt(j) == '1') oneCount[i]++;
            }
        }
        for (int i = 0; i < zeroCount.length; i++) {
            for (int j = m; j >= zeroCount[i]; j--) {
                for (int k = n; k >= oneCount[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroCount[i]][k - oneCount[i]] + 1);

                }
            }
        }
        return dp[m][n];
    }

}
