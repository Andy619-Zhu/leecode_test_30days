package com.goo.test.rollBackAlgo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77 题
 * @author Lenovo
 */
public class Combinations {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    @Test
    public void test() {
        List<List<Integer>> res = combine(4,2);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        backTracking(9, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++){
            path.add(i);
            backTracking(n, k , i + 1);
            path.removeLast();
        }
    }
}




