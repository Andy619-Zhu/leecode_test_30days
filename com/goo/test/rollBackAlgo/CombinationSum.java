package com.goo.test.rollBackAlgo;

import org.junit.Test;

import java.util.*;

/**39题
 * @author Lenovo
 */
public class CombinationSum {

    @Test
    public void test() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = combinationSum(candidates, target);

        for (List<Integer> re : res) {
            System.out.println(re);
        }
//        for (List<Integer> re : res) {
//            List<Integer> REE = re.stream().sorted(Comparator.comparing(Integer::byteValue)).toList();
//            set.add(REE);
//        }
//        for (List<Integer> integers : set) {
//            System.out.println(integers);
//        }

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        trackBack(candidates, target, 0);
        for (List<Integer> re : result) {
            List<Integer> REE = re.stream().sorted(Comparator.comparing(Integer::byteValue)).toList();
            set.add(REE);
        }
        return new ArrayList<>(set);
    }

    public void trackBack(int[] candidates, int target, int index) {
        int sum = path.stream().mapToInt(tempInt -> tempInt).sum();
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            trackBack(candidates, target, index);
            path.removeLast();
        }

    }
}
