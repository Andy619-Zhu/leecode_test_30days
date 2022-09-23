package com.goo.test.nums;

import org.junit.Test;

public class remove_element {

    @Test
    public void main() {
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int element = removeElement(nums, val);
        System.out.println("***********************");
        System.out.println(element);
    }


    public int removeElement(int[] nums, int val) {

        int slow = 0;
        int fast = 0;
        if (nums.length == 1 && nums[0] != val) {
            return 1;
        }
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }
        while (fast <= nums.length - 1) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                if (fast < (nums.length - 1) && nums[fast + 1] != val) {
                    nums[slow] = nums[fast + 1];
                }
                fast++;
            }
        }
        for (int i : nums) {
            System.out.println(i);
        }
        return slow;
    }
}
