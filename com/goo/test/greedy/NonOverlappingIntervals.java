package com.goo.test.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 435
 *
 * @author Lenovo
 */
public class NonOverlappingIntervals {

    @Test
    public void test() {
//        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals = {{1,2}, {1,2}, {1,2}};
        int[][] intervals = {{1,2}, {2,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int count = 1;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] < intervals[j][1] && intervals[i][1] <= intervals[j][0]) {
                    count = count + 1;
                    i = j;
                }
            }
        }
        return intervals.length - count;
    }
}
