package com.goo.test.StackAndQueue;

import org.junit.Test;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {


    @Test
    public void test() {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public String removeDuplicates(String s) {

        Stack<Character> myStack = new Stack<>();
        String s1 = new String();
        int index = 0;
        while (index < s.length()) {
            if (myStack.isEmpty()) {
                myStack.push(s.charAt(index));
                index++;
            } else if (myStack.peek() == s.charAt(index)) {
                myStack.pop();
                index++;
            } else {
                myStack.push(s.charAt(index));
                index++;
            }
        }
        for (Character character : myStack) {
            s1 = s1+character;
        }
       return s1;
    }
}
