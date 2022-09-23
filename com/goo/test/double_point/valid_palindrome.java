package com.goo.test.double_point;

import org.junit.Test;


/**
 * 680
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * <p>
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 * <p>
 * 所谓的回文字符串，是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串。
 * <p>
 * 使用双指针可以很容易判断一个字符串是否是回文字符串：令一个指针从左到右遍历，一个指针从右到左遍历，这两个指针同时移动一个位置，每次都判断两个指针指向的字符是否相同，如果都相同，字符串才是具有左右对称性质的回文字符串。
 * <p>
 * <p>
 * <p>
 * 本题的关键是处理删除一个字符。在使用双指针遍历字符串时，如果出现两个指针指向的字符不相等的情况，我们就试着删除一个字符，再判断删除完之后的字符串是否是回文字符串。
 * <p>
 * 在判断是否为回文字符串时，我们不需要判断整个字符串，因为左指针左边和右指针右边的字符之前已经判断过具有对称性质，所以只需要判断中间的子字符串即可。
 * <p>
 * 在试着删除字符时，我们既可以删除左指针指向的字符，也可以删除右指针指向的字符。
 **/
public class valid_palindrome {
    @Test
    public void test() {
        String s = "eeccccbebaeeabebccceea";
        String s1 = "eedede";
        String s2 = "aydmda";
        String s3 = "ececabbacec";  //true

        boolean validPalindrome = validPalindrome(s3);
        System.out.println(validPalindrome);

    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}