package com.goo.test.DynamicProgramming;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LastStoneWeight {

    /**
     * 1049
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,7,4,1,8,1};
        List<Integer> stones = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(lastStoneWeight(stones));
    }

    /**
     *
     * @param stones
     * @return
     */

    public static int lastStoneWeight(List<Integer> stones){
        if (stones.size() == 0){return 0;}
        if (stones.size() == 1){return stones.get(0);}
        stones.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        if ((int)stones.get(0) == stones.get(1)){
            stones.remove(0);
            stones.remove(0);
        }else {
            int abs = Math.abs(stones.get(0) - stones.get(1));
            stones.remove(0);
            stones.remove(0);
            stones.add(abs);
        }
        return lastStoneWeight(stones);

    }

}
