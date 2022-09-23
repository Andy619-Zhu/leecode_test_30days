package com.goo.test.StackAndQueue;

import java.util.Stack;

/**
 * @author Lenovo
 */
public class MyQueue {

    Stack<Integer> stIn = new Stack<Integer>();
    public MyQueue() {

    }

    public void push(int x) {
        stIn.push(x);
        System.out.println(x);
    }

    public int pop() {
        return stIn.remove(0);

    }

    public int peek() {
        return stIn.firstElement();
    }

    public boolean empty() {
        return stIn.isEmpty();
    }
}
