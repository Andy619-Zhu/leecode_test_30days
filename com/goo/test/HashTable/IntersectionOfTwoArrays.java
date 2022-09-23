package com.goo.test.HashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**349
 * @author Lenovo
 */
public class IntersectionOfTwoArrays {

    @Test
    public void test(){
        int[] nums2 = {4,7,9,7,6,7};
        int[] nums1 = {5,0,0,6,1,6,2,2,4};
        int[] res = intersection(nums1,nums2);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> num1 = new HashSet<>();
        Set<Integer> num2 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        int lastNumSize = 0;
        for (int i : nums1) {
            num1.add(i);
        }
        for (int i : nums2) {
            num2.add(i);
        }
        lastNumSize = num1.size();
        for (Integer j : num2) {
            num1.add(j);
            if (lastNumSize == num1.size()){
                result.add(j);
            }
            lastNumSize = num1.size();
        }

        int[] res = new int[result.size()];
        int resIndex = 0;
        for (Integer integer : result) {
            res[resIndex] = integer;
            resIndex++;
        }
        return res;
    }
}
