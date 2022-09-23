package com.goo.test.HashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 202
 *
 * @author Lenovo
 */
public class HappyNumber {

    @Test
    public void test() {

        int n = Integer.MAX_VALUE;
        System.out.println(isHappy(19));

    }

    public boolean isHappy(int n) {
        Set<Integer> sumNum = new HashSet<>();
        int size = sumNum.size();
        int result = squareSum(n);
        while (result != 1) {
            result = squareSum(n);
            sumNum.add(result);
            if (size == sumNum.size()) {
                return false;
            }
            n = result;
            size = sumNum.size();
        }
        return true;
    }

    public int squareSum(int n) {

        int[] nums = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (n / Math.pow(10, i)) % 10;
        }
        for (int i : nums) {
            sum = sum + i * i;
        }
        return sum;
    }
}
