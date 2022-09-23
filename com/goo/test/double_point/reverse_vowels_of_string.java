package com.goo.test.double_point;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * 345*
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: "leotcede"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 * <p>
 * <p>
 * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
 * <p>
 * 为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
 * <p>
 * 时间复杂度为 O(N)：只需要遍历所有元素一次
 * <p>
 * 空间复杂度 O(1)：只需要使用两个额外变量
 */
public class reverse_vowels_of_string {

    @Test
    public void test() {
        String s11 = "leecode";
        String s22 = "race car";   //"race car"
        char[] chs = s11.toCharArray();
        char ch1 = s11.charAt(1);
        char ch4 = s11.charAt(4);
        chs[1] = ch4;
        chs[4] = ch1;
        System.out.println(new String(chs));


        String reverseVowels = reverseVowels(s22);
        System.out.println(reverseVowels);

    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        char tempi, tempj;
        Set<Character> set = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        while (i < j) {
            if (set.contains(chars[i])) {
                tempi = chars[i];
                if (set.contains(chars[j])) {
                    tempj = chars[j];
                    chars[i] = tempj;
                    chars[j] = tempi;
                    j--;
                    i++;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return new String(chars);
    }
}
