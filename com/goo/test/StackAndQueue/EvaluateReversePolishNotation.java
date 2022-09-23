package com.goo.test.StackAndQueue;

import org.junit.Test;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {

    @Test
    public void test() {
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }

    public int evalRPN(String[] tokens) {
        LinkedList<String> myQueue = new LinkedList<>();
        int index = 0;
        while (index < tokens.length) {

            myQueue.add(tokens[index]);

            if ("+".equals(myQueue.getLast()) || "-".equals(myQueue.getLast()) || "*".equals(myQueue.getLast()) || "/".equals(myQueue.getLast())) {
                int calThreeElement = calThreeElement(myQueue.get(myQueue.size()-3), myQueue.get(myQueue.size()-2), myQueue.getLast());
                myQueue.removeLast();
                myQueue.removeLast();
                myQueue.removeLast();
                myQueue.add(String.valueOf(calThreeElement));
            }
            index++;
        }
        return Integer.parseInt(myQueue.getFirst());

    }

    public int calThreeElement(String s1, String s2, String s3) {

        return switch (s3) {
            case "+" -> Integer.parseInt(s1) + Integer.parseInt(s2);
            case "-" -> Integer.parseInt(s1) - Integer.parseInt(s2);
            case "*" -> Integer.parseInt(s1) * Integer.parseInt(s2);
            case "/" -> Integer.parseInt(s1) / Integer.parseInt(s2);
            default -> 0;
        };

    }
}
