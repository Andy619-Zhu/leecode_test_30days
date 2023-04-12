package com.goo.test.DynamicProgramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 746 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    @Test
    public void test() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {

        List<Integer> a = new ArrayList<>(cost.length + 1);
        a.add(0, 0);
        a.add(1, 0);
        for (int i = 2; i <= cost.length; i++) {
            a.add(i, Math.min(a.get(i - 1) + cost[i - 1], a.get(i - 2) + cost[i - 2]));
        }
        return a.get(a.size()-1);
    }

}
