package com.goo.test.charString;

import org.junit.Test;

public class ImplementStrstr {

    /** 28
     * "mississippi"
     * "issi"
     *
     * "mississippi"
     * "issipi"
     */
    @Test
    public void test() {
        String haystack = "abc";
        String needle = "c";

        System.out.println(strStr(haystack, needle));

    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int hayLen = haystack.length();
        int neeLen = needle.length();
        if (hayLen < neeLen) {
            return -1;
        }
        int temp = 0;
        int leftHay = 0;
        int leftNee = 0;
        while (hayLen - leftHay >= neeLen ) {
            temp = leftHay;
            while (haystack.charAt(leftHay) == needle.charAt(leftNee)) {
                leftHay++;
                leftNee++;
                if (leftNee >= neeLen) {
                    return temp;
                }
            }
            leftNee = 0;
            leftHay = temp;
            leftHay++;
        }
        return -1;
    }
}
