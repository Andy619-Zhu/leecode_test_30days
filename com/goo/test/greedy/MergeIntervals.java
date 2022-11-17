package com.goo.test.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lenovo
 */
public class MergeIntervals {

    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][intervals[0].length];
        Arrays.sort(intervals, (a, b) -> {
                    if (a[1] == b[1]) {
                        return a[0] - b[0];
                    }
                    return a[1] - b[1];
                }
        );
        for (int i = 0; i < intervals.length; i++) {
            int startIndex = i;
            for (int j = i; j < intervals.length; j++) {
                if (intervals[i][1] < intervals[j][0]) {
                    result[startIndex][0] = intervals[startIndex][0];
                    result[startIndex][1] = intervals[j - 1][1];
                    break;
                }
                i = j;
            }
            if (startIndex == intervals.length - 1) {
                result[startIndex][0] = intervals[startIndex][0];
                result[startIndex][1] = intervals[startIndex][1];
            }

        }
        Object[] objects = Arrays.stream(result).filter(o -> o[0] != 0 && o[1] != 0).toArray();
        for (Object object : objects) {
//            char c = object.toString().charAt(0);
            for (byte aByte : object.toString().getBytes()) {
                System.out.println(aByte);
            }
        }
        return null;
    }
}
