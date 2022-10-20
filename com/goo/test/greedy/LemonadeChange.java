package com.goo.test.greedy;

import org.junit.Test;

/**
 * @author Lenovo
 */
public class LemonadeChange {
    @Test
    public void test() {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }


    public boolean lemonadeChange(int[] bills) {
        int[] count51020 = {1, 0, 0};
        if (bills[0] != 5) {
            return false;
        }

        for (int i = 1; i < bills.length; i++) {
            if (bills[i] == 5) {
                count51020[0]++;
            } else if (bills[i] == 10) {
                count51020[1]++;
                count51020[0]--;
                if (count51020[0] < 0) {
                    return false;
                }
            } else {
                count51020[2]++;
                if (count51020[1] != 0) {
                    count51020[1]--;
                    count51020[0]--;
                } else {
                    count51020[0]--;
                    count51020[0]--;
                    count51020[0]--;
                }
                if (count51020[0] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
