package com.goo.test.charString;

/**
 * @author AndyChu
 */
public class RepeatedSubstringPattern {


    public void test() {

    }

    public boolean repeatedSubstringPattern(String s) {
        int sLen = s.length();
        if (sLen % 2 != 0) {
            return false;
        }
        StringBuilder sTemp = new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        int lowIndex = 0;
        int lowIndexTemp = 0;
        while (lowIndex < sLen / 2){

            lowIndex++;
        }

            return true;
    }

}
