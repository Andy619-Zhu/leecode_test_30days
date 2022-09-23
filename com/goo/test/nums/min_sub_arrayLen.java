package com.goo.test.nums;

import org.junit.Test;

public class min_sub_arrayLen {

    @Test
    public void test() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = minSubArrayLenEg(target, nums);
        System.out.println(res);

    }


    public int minSubArrayLen(int target, int[] nums) {
        int window_start = 0;
        int window_end = 0;
        int window_sum = nums[0];
        int last_window_length = 0;

        while (window_end < nums.length - 1) {

            if (window_sum < target) {
                window_end++;
                window_sum = window_sum + nums[window_end];

            } else {
                last_window_length = window_end - window_start+1;
                window_start++;
                window_sum = window_sum - nums[window_start];

            }
        }


        return window_end - window_start+1;
    }
    // 滑动窗口
    public int minSubArrayLenEg(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int slide(int target, int window_sum) {
        while (window_sum >= target) {

        }
        return 0;
    }
}
