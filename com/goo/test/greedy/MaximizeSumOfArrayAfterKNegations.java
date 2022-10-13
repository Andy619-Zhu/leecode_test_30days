package com.goo.test.greedy;

import org.junit.Test;

import java.util.Arrays;

/**1005
 * @author Lenovo
 */
public class MaximizeSumOfArrayAfterKNegations {

    @Test
    public void test() {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; //6
//        int[] nums = {0};//0
//        int[] nums = {-1};//-1
//        int[] nums = {-2,-1};//-1
        int[] nums = {2,-3,-1,5,-4};//-1
//        int[] nums = {3,-1,0,2};//-1

        int k = 2;
        System.out.println(largestSumAfterKNegations(nums,k));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] numsSort = Arrays.stream(nums).sorted().toArray();
        while (k>0){
            numsSort = Arrays.stream(numsSort).sorted().toArray();
            numsSort[0] = -numsSort[0];
            k--;
        }
        int sum = Arrays.stream(numsSort).sum();
        return sum;
    }
}
