package com.goo.test.greedy;


import org.junit.Test;

/**
 * @author
 */
public class Candy {

    @Test
    public void test() {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }

    public int candy(int[] ratings) {
        int result = 1;
        int count = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] == ratings[i - 1]) {
                result++;
                continue;
            }
            if (ratings[i] > ratings[i - 1]) {
                count++;
                result = result + count;
            }else {
                count = 1;
            }
        }
        return result;
    }
}
