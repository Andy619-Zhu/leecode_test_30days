package com.goo.test.nums;

import org.junit.Test;

import java.util.Arrays;


/**
 * 输入：nums = [
 * 5,7,7,8,8,10]
 * , target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [
 * 5,7,7,8,8,10]
 * , target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class SearchRange {

    @Test
    public void test() {
        int[] nums = {0,1, 1, 1,2};
        int target = 1;
        int[] range = searchRange(nums, target);
        for (int i : range) {
            System.out.println(i);
        }

    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int midNum;
        int midIndex;
        int[] result = {-1, -1};

        if (high < 0 || target < nums[low] || target > nums[high]) {
            return result;
        } else if (high == 0) {
            if (nums[0] == target) {
                result[0] = 0;
                result[1] = 0;
            }
            return result;
        }

        while (low <= high) {
            midIndex = low + (high - low) / 2;
            midNum = nums[midIndex];
            if (target < midNum) {
                high = midIndex - 1;
            } else if (target > midNum) {
                low = midIndex + 1;
            } else {
                result[0] = midIndex;
                result[1] = midIndex;
                low = midIndex;
                high = midIndex;
                while (low > 0 && nums[low - 1] == target) {
                    low--;
                    result[0]--;
                }
                while (high < nums.length - 1 && nums[high + 1] == target) {
                    high++;
                    result[1]++;
                }
                return result;
            }
        }
        return result;
    }

}
