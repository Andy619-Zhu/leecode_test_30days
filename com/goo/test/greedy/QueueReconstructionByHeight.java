package com.goo.test.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/** 406
 * @author Lenovo
 */
public class QueueReconstructionByHeight {
    @Test
    public void test() {
//        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] people = {{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};//[[3,0],[6,0],[7,0],[5,2],[3,4],[5,3],[6,2],[2,7],[9,0],[1,9]]
        reconstructQueue(people);
    }

    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);
    }
}
