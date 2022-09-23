package com.goo.test.charString;

import org.junit.Test;

/** 151
 * @author Lenovo
 */
public class ReverseWordsInAString {

    @Test
    public void test() {
        String s = "t sky     is blue";
        System.out.println(reverseWords(s));
    }


    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        int right = s.length() - 1;
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) != ' ') {
                temp.append(s.charAt(right));
                right--;
            }
            temp.reverse();
            if (!temp.isEmpty()) {
                sb.append(temp + " ");
                temp.delete(0, temp.length());
            }
            right--;
        }
        if (sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }

}
