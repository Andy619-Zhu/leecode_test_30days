package com.goo.test.greedy;

import org.junit.Test;

/**
 * 376
 *
 * @author Lenovo
 */
public class WiggleSubsequence {
    @Test
    public void test() {
//        int[] nums = {1,7,4,9,2,5};
//        int[] nums = {1,17,5,10,13,15,10,5,16,8};
//        int[] nums = {1,1,7,4,9,2,5};
        int[] nums = {3, 3, 3, 2, 5};  //3
        System.out.println(wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        boolean flag = true;
        boolean f = true;
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if ((f && nums[i] - nums[i - 1] > 0) || (!flag && nums[i] - nums[i - 1] > 0)) {
                flag = true;
                f = false;
                count = count + 1;
            }
            if ((f && nums[i] - nums[i - 1] < 0) || (flag && nums[i] - nums[i - 1] < 0)) {
                flag = false;
                f = false;
                count = count + 1;
            }
        }
        return count;
    }
}
