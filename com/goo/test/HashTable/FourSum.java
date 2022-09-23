package com.goo.test.HashTable;

import java.util.*;

/**  18
 * @author Lenovo
 */
public class FourSum {


    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int[] numSort = Arrays.stream(nums).sorted().toArray();
        if (numSort.length<4){return new ArrayList<>();}
        if (numSort[0] == numSort[numSort.length - 1] && target == numSort[0]*4) {
            List<Integer> temp = new ArrayList<>();
            temp.add(numSort[0]);
            temp.add(numSort[0]);
            temp.add(numSort[0]);
            temp.add(numSort[0]);
            List<List<Integer>> res = new ArrayList<>();
            res.add(temp);
            return res;

        }
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < numSort.length; i++) {
            for (int j = i + 1; j < numSort.length; j++) {
                for (int k = j + 1; k < numSort.length; k++) {
                    for (int l = k + 1; l < numSort.length; l++) {
                        if (target == numSort[i] + numSort[j] + numSort[k] + numSort[l]) {
                            if (i != j && i != k && i != l && j != k && j != l && k != l) {
                                List<Integer> temp = new ArrayList<>();
                                temp.add(numSort[i]);
                                temp.add(numSort[j]);
                                temp.add(numSort[k]);
                                temp.add(numSort[l]);
                                res.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return res.stream().toList();
    }
}
