package com.goo.test.rollBackAlgo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17 电话号码组合
 *
 * @author Lenovo
 */
public class LetterCombinationsOfAPhoneNumber {


    @Test
    public void test() {
        System.out.println(letterCombinations(""));
    }

    static String[] str = {"", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };
    LinkedList<String> ls = new LinkedList<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {


        backTracking(digits, str, 0);
        if (result.get(0).equals("")){
            return new ArrayList<>();
        }
        return result;
    }

    public void backTracking(String digits, String[] str, int index) {
        if (ls.size() == digits.length()) {
            String lll = new String();
            for (String l : ls) {
                lll = lll + l;
            }
            result.add(lll);
            return;
        }
        String s = str[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            ls.add(String.valueOf(s.charAt(i)));
            backTracking(digits, str, index + 1);
            ls.removeLast();
        }
    }
}
