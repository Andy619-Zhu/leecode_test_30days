package com.goo.test.HashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1
 *
 * @author Lenovo
 */
public class TwoSum {

    @Test
    public void test() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] res = twoSum(nums, target);

        for (int re : res) {
            System.out.println(re);
        }

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapNum = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            mapNum.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (mapNum.containsKey(delta) && mapNum.get(delta) != i) {
                return new int[]{i, mapNum.get(delta)};
            }
        }
        return null;
    }

}
