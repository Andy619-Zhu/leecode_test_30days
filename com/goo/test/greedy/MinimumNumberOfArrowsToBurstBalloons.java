package com.goo.test.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 452
 *
 * @author Lenovo
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    @Test
    public void test() {

//        int[][] people = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};//2
//        int[][] people = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};//4
//        int[][] people = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};//4
//        int[][] people = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] people = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};//2
//        int[][] people = {{10,16},{2,8},{1,6},{7,12}}; //2
        System.out.println(findMinArrowShots(people));
    }

    public int findMinArrowShots(int[][] points) {
        int count = 0;
        int r = Integer.MAX_VALUE;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            if (((long) a[0] - (long) b[0]) > 0) {
                return 1;
            }
            return -1;
        });
        for (int i = 0, index = 0; index < points.length; i++) {
            r = Math.min(r, points[index][1]);
            if (index + 1 < points.length && r >= points[index + 1][0]) {
                index++;
                i--;
            } else {
                count++;
                i = index;
                index++;
                if (index < points.length) {
                    r = points[index][1];
                }
            }
        }
        return count;
    }
}
