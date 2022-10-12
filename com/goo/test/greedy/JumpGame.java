package com.goo.test.greedy;

import org.junit.Test;

/**55
 * @author Lenovo
 */
public class JumpGame {
    @Test
    public void test() {

//        int[] prices = {2,3,1,1,4}; //t
//        int[] prices = {3, 2, 1, 0, 4}; //f
        int[] prices = {3, 2, 2, 0, 4};
//        int[] prices = {2, 1, 2, 0, 1};
        System.out.println(canJump(prices));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return false;
        }
        int arrive;
        int maxArrive = 0;
        for (int i = 0; i < nums.length; i++) {
            arrive = i + nums[i];
            if (maxArrive < arrive) {
                maxArrive = arrive;
            }
            if (nums[i] == 0 && maxArrive <= i) {
                return false;
            }
            if (arrive >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
