package com.goo.test.StackAndQueue;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {


    @Test
    public void test() {
        int[] nums = {1};
        int k = 1;
        int[] res = topKFrequent(nums, k);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while (index < nums.length) {
            if (map.containsKey(nums[index])) {
                map.put(nums[index], map.get(nums[index])+1);
            }else {
                map.put(nums[index],1);
            }
            index++;
        }
        int[] res = new int[k];
        Map<Integer, Integer> collect = sortMap(map);
        List<Integer> integers = collect.keySet().stream().collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            res[i] = integers.get(i);
        }
        return res;
    }
    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> map) {
        //利用Map的entrySet方法，转化为list进行排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        //利用Collections的sort方法对list排序
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //正序排列，倒序反过来
                return (int) (o2.getValue() - o1.getValue());
            }
        });
        //遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> e : entryList) {
            linkedHashMap.put(e.getKey(), e.getValue());
        }
        return linkedHashMap;
    }
}
