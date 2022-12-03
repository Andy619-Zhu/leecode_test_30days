package com.goo.test.greedy;

import org.junit.Test;

/**
 * @author Lenovo
 * 738
 */
public class MonotoneIncreasingDigits {

    @Test
    public void test() {
        System.out.println(monotoneIncreasingDigits(190));
    }

    public int monotoneIncreasingDigits(int n) {
        StringBuilder stringBuffer = new StringBuilder(String.valueOf(n));
        int index = stringBuffer.length();
        for (int i = stringBuffer.length() - 1; i > 0; i--) {
            if (stringBuffer.charAt(i - 1) > stringBuffer.charAt(i) ) {
                stringBuffer.setCharAt(i - 1, (char) (stringBuffer.charAt(i - 1) - 1));
                index = i;
            }
        }
        for (int i = index; i < stringBuffer.length(); i++) {
            stringBuffer.setCharAt(i,'9');
        }
        return Integer.parseInt(stringBuffer.toString());
    }
}