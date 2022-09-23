package com.goo.test.HashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 383
 *
 * @author Lenovo
 */
public class RansomNote {

    @Test
    public void test() {
        String a = "aa";
        String b = "ab";
        System.out.println(canConstruct(a,b));
    }


    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.isEmpty()) {
            return false;
        }
        Map<Character, Integer> magMap = new HashMap<>(magazine.length());
        for (int i = 0; i < magazine.length(); i++) {
            if (!magMap.containsKey(magazine.charAt(i))) {
                magMap.put(magazine.charAt(i), 1);
            } else {
                magMap.put(magazine.charAt(i), magMap.get(magazine.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (magMap.containsKey(ransomNote.charAt(i)) && magMap.get(ransomNote.charAt(i)) != 0) {
                magMap.put(ransomNote.charAt(i), magMap.get(ransomNote.charAt(i))-1);
            } else {
                return false;
            }
        }
        return true;
    }
}
