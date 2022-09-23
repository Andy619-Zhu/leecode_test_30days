package com.goo.test.HashTable;

import org.junit.Test;

import java.util.*;


/**
 * 15
 *
 * @author Lenovo
 */
public class ThreeSum {

    @Test
    public void test() {
        int[] nums = {0, 0, 0, 0, 0, 0};

        List<List<Integer>> listList = threeSum(nums);
        for (List<Integer> integerList : listList) {
            for (Integer integer : integerList) {
                System.out.println(integer);
            }
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        int[] numSort = Arrays.stream(nums).sorted().toArray();
        Set<List<Integer>> res = new HashSet<>();
        int left = 1;
        int right = numSort.length - 1;
        int sub = 2;
        int abcSum = 0;
        for (int i = 0; i < numSort.length - sub; i++) {
            while (left < right) {
                abcSum = numSort[i] + numSort[left] + numSort[right];
                if (abcSum > 0) {
                    right--;
                } else if (abcSum < 0) {
                    left++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(numSort[i]);
                    temp.add(numSort[left]);
                    temp.add(numSort[right]);
                    res.add(temp);
                    left++;
                }
            }
            left = i + 2;
            right = numSort.length - 1;
        }
        return res.stream().toList();
    }
}
