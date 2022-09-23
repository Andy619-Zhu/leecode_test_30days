package com.goo.test.double_point;

/**
 * @author Lenovo
 */
public class ReverseString {


    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char tempChar;
        while (left < right) {
            tempChar = s[left];
            s[left] = s[right];
            s[right] = tempChar;
            left++;
            right--;
        }
    }

}
