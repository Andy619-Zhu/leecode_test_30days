package com.goo.test.HashTable;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 454
 *
 * @author Lenovo
 */
public class FourSumIi {

    @Test
    public void test() {
        int[] n1 ={1,2};
        int[] n2 ={-2,-1};
        int[] n3 ={-1,2};
        int[] n4 ={0,2};

        System.out.println(fourSumCount(n1,n2,n3,n4));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> abSum = new HashMap<>();
//        Map<Integer, Integer> abcdSum = new HashMap<>();
        int count = 0;
        int abSumTemp = 0;
        int abcdSumTemp = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                abSumTemp = nums1[i] + nums2[j];
                if (abSum.containsKey(abSumTemp)) {
                    abSum.put(abSumTemp, abSum.get(abSumTemp) + 1);
                } else {
                    abSum.put(abSumTemp, 1);
                }
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                abcdSumTemp = -(nums3[i] + nums4[j]);
                if (abSum.containsKey(abcdSumTemp)) {
                    count = abSum.get(abcdSumTemp) + count;

                }
            }
        }

        return count;
    }
}
