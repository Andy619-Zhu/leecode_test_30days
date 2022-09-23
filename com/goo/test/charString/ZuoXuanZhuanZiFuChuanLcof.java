package com.goo.test.charString;

import org.junit.Test;

/**
 * @author Lenovo
 */
public class ZuoXuanZhuanZiFuChuanLcof {

    @Test
    public void test() {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseLeftWords(s, k));
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        int preLen = sb.length();
        sb.setLength(preLen + n);
        for (int i = 0; i < n; i++) {
            sb.setCharAt(preLen, sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
