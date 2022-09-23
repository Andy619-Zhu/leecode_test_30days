package com.goo.test.nums;

import org.junit.Test;

import java.util.Arrays;

public class sorted_squares {

    @Test
    public void test() {
        int[] nums = {-7,-3,2,3,11};
        int[] res = sortedSquares(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] sortedSquares(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int result_index = nums.length - 1;
        int[] result = new int[nums.length];
        while (high >= low) {
            int nums_low_square = nums[low] * nums[low];
            int nums_high_square = nums[high] * nums[high];
            if (nums_high_square > nums_low_square) {
                result[result_index] = nums_high_square;
                high--;
                result_index--;
            } else {
                result[result_index] = nums_low_square;
                low++;
                result_index--;
            }
        }
        return result;
    }
}
