package com.goo.test.StackAndQueue;

import org.junit.Test;

import java.util.Stack;

public class ValidParentheses {

    @Test
    public void test() {
        String s = "(([]){})";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> myStack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (myStack.isEmpty()) {
                myStack.push(s.charAt(index));
                index++;
            } else if (myStack.peek() == s.charAt(index) - 1 || myStack.peek() == s.charAt(index) - 2) {
                myStack.pop();
                index++;
            } else {
                myStack.push(s.charAt(index));
                index++;
            }

        }
        return myStack.isEmpty();
    }


}
