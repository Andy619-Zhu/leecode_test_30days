package com.goo.test.nums;

import org.junit.Test;

/**
 * @author Lenovo
 */
public class SearchInsert {

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6, 7, 8, 9, 10};
        int target = 2;
        int x = searchInsert(nums, target);
        System.out.println(x);
    }

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length;
        int mid_index = 0;
        int mid_num;

        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[high - 1]) {
            return nums.length;
        }

        while (low <= high) {
            mid_index = low + (high - low) / 2;
            mid_num = nums[mid_index];
            if (target < mid_num) {
                high = --mid_index;
            } else if (target > mid_num) {
                low = ++mid_index;
            } else {
                return mid_index;
            }
        }
        return high + 1;
    }
}
