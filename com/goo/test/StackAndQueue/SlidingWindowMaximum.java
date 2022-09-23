package com.goo.test.StackAndQueue;

import org.junit.Test;

import java.util.*;

public class SlidingWindowMaximum {
    @Test
    public void test() {
        int[] nums = {};
        int k = 0;
        int[] res = maxSlidingWindow(nums, k);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        LinkedList<Integer> myQueue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int index = 0;

        while (index < nums.length) {

            while (!myQueue.isEmpty() && nums[index] > nums[myQueue.getLast()]) {
                myQueue.removeLast();
            }
            myQueue.add(index);

            if (index - myQueue.getFirst() == k) {
                myQueue.remove(0);
            }
            if (index >= k - 1) {
                res.add(nums[myQueue.getFirst()]);
            }
            index++;

        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


}
