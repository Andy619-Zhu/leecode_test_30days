package com.goo.test.charString;

import org.junit.Test;

/**
 * 541
 *
 * @author Lenovo
 */
public class ReverseStringIi {

    @Test
    public void test() {

        /**"fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi"**/

        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;
        System.out.println(s.length());
        String res = reverseStr(s, k);
        System.out.println(res);

    }

    public String reverseStr(String s, int k) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        char[] s1 = s.toCharArray();
        char[] res = s1;
        int count2K = s.length() / 2 / k;
        int count1k = (s.length() - count2K * 2 * k) / k;
        for (int i = 0; i < count2K; i++) {
            res = reverseStr2k(s1, k, i);
            s1 = res;
        }
        if (count1k == 0){
            res = reverseStr0K(s1, k, count2K * 2 * k + count1k * k);
        }
        if (count1k == 1){
            for (int j = 0; j < count1k; j++) {
                res = reverseStr1K(s1, k, count2K * 2 * k);
                s1 = res;
            }
        }
        String temp = "";
        for (char re : res) {
            temp += re;
        }
        return temp;
    }

    public char[] reverseStr2k(char[] s, int k, int i) {
        int low = i * 2 * k;
        int high = low + k - 1;
        char temp;
        while (low < high) {
            temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
        return s;
    }

    public char[] reverseStr1K(char[] s, int k, int i) {
        int low = i;
        int high = i + k - 1;
        char temp;
        while (low < high) {
            temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
        return s;
    }

    public char[] reverseStr0K(char[] s, int k, int i) {
        int low = i;
        int high = s.length - 1;
        char temp;
        while (low < high) {
            temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
        return s;
    }
}
