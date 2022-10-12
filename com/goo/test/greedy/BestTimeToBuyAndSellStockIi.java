package com.goo.test.greedy;

import org.junit.Test;

/**
 * 122
 *
 * @author Lenovo
 */
public class BestTimeToBuyAndSellStockIi {

    @Test
    public void test() {

//        int[] prices = {2,3,1,1,4}; //7
//        int[] prices = {1,2,3,4,5}; //4
//        int[] prices = {7,6,4,3,1};
        int[] prices = {2, 1, 2, 0, 1};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        int buyPrice = 0;
        boolean buyFlag = false;
        int soldPrice = 0;
        boolean soldFlag = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                buyPrice = prices[i - 1];
                buyFlag = true;
            }
            if (prices[i] > prices[i - 1]) {
                soldPrice = prices[i];
                soldFlag = true;
            }
            if (buyFlag && soldFlag) {
                result = result + soldPrice - buyPrice;
                buyFlag = false;
                soldFlag = false;
            }
        }
        return result;
    }
}
