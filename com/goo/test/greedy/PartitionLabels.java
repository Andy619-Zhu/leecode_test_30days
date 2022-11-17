package com.goo.test.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763
 */
public class PartitionLabels {

    @Test
    public void test() {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> rex = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            rex.put(s.charAt(i), i);
        }
        List<Integer> index = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (right < rex.get(s.charAt(i))) {
                right = rex.get(s.charAt(i));
            }
            if (right == i) {
                index.add(i);
            }
        }
        result.add(index.get(0) + 1);
        for (int i = 1; i < index.size(); i++) {
            result.add(index.get(i) - index.get(i - 1));
        }
        return result;
    }
}
