package com.goo.test.charString;

import org.junit.Test;

/**
 * offer 05.
 *
 * @author Lenovo
 */
public class TiHuanKongGeLcof {
    @Test
    public void test() {
        String s = "we are happy";
        String res = replaceSpace(s);
        System.out.println(res);
    }

    public String replaceSpace(String s) {

        int n = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                s = s + "  ";
                n = n+1;

            }
        }
        char[] res = s.toCharArray();
        int right = res.length - 1;
        int left = len - 1;
        while (right > left) {
            if (res[left] != ' ') {
                res[right] = res[left];
                right--;
                left--;
            } else {
                res[right--] = '0';
                res[right--] = '2';
                res[right--] = '%';
                left--;
            }
        }
        String result = "";
        for (char c : res) {
            result = result + c;
        }
        return result;
    }
}
