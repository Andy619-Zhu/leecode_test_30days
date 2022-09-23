package com.goo.test.nums;

import org.junit.Test;

public class split2_find {


    @Test
    public void test() {

        int[] nums = {1, 2, 3, 4, 5, 6, 9, 10};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public int search(int[] nums, int target) {

        int nums_length = nums.length - 1;
        int temp_index = 0;
        int middle_index;
        if (nums[0] == target) {
            return 0;
        }
        if (nums[nums_length] == target) {
            return nums_length;
        }
        while (temp_index <= nums_length) {
            middle_index = (temp_index + nums_length) / 2 + temp_index;
            int temp_middle_num = nums[middle_index];
            if (temp_middle_num == target) {
                return middle_index;
            } else if (temp_middle_num > target) {
                nums_length = middle_index + 1;
            } else {
                temp_index = middle_index - 1;
            }
        }

        return -1;
    }
}
