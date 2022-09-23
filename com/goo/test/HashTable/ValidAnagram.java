package com.goo.test.HashTable;

import org.junit.Test;

/**
 * 242
 *
 * @author Lenovo
 */
public class ValidAnagram {

    @Test
    public void test() {

    }

    public boolean isAnagram(String s, String t) {

        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a'] += 1;
        }
        for (int j = 0; j < t.length(); j++) {
            record[t.charAt(j) - 'a'] -= 1;
        }
        for (int zero : record) {
            if (zero != 0) {
                return false;
            }
        }
        return true;
    }

}
