package com.goo.test.rollBackAlgo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216题
 * @author
 */
public class CombinationSumIii {
    @Test
    public void test(){
        List<List<Integer>> res = combinationSum3(3, 9);
        for (List<Integer> re : res) {
            System.out.println(re);
        }


    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,1);
        return result;

    }
    
    public void backTracking(int n, int k, int startIndex){
        if (path.size() == k){
            int sumN = 0;
            ArrayList<Integer> pathTemp = new ArrayList<>(path);
            for (Integer i : pathTemp) {
                sumN = sumN + i;
            }
            if (sumN == n){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < n; i++) {
            path.add(i);
            backTracking(n,k,i+1);
            path.removeLast();
        }
    }
    
}
