package com.goo.test.greedy;

import org.junit.Test;

/**
 * 45
 *
 * @author Lenovo
 */
public class JumpGameIi {
    @Test
    public void test() {

        int[] prices = {2, 3, 1, 1, 4}; //t
//        int[] prices = {3, 2, 1, 0, 4}; //f
//        int[] prices = {3, 2, 2, 0, 4};
//        int[] prices = {2, 1, 2, 0, 1};
//        int[] prices = {1}; //t
//        int[] prices = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(prices));
    }

    public int jump(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count = 0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }


}
