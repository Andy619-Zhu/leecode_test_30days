package com.goo.test.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 134
 *
 * @author Lenovo
 */
public class GasStation {
    @Test
    public void test() {
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
//        int[] gas = {3,1,1};
//        int[] cost = {1,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = -1;
        int gasLeft = 0;
        boolean flag = false;
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] == 0 && cost[i] == 0) {
                continue;
            }
            if (gas[i] >= cost[i]) {
                for (int k = i; k < gas.length; k++) {
                    gasLeft = gas[k] - cost[k] + gasLeft;
                    if (flag && startIndex == i && gasLeft >= 0) {
                        return i;
                    }
                    if (gasLeft < 0) {
                        startIndex = -1;
                        gasLeft = 0;
                        flag = false;
                        break;
                    }
                    if (k == gas.length - 1) {
                        k = -1;
                        flag = true;
                    }
                    if (flag) {
                        startIndex++;
                    }
                }
            }
        }
        return -1;
    }
}
