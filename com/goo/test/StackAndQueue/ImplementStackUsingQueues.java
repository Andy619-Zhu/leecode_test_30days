package com.goo.test.StackAndQueue;

import java.util.LinkedList;

public class ImplementStackUsingQueues {


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False

    }


    static class MyStack {
        LinkedList<Integer> stackUseQueue = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            stackUseQueue.add(x);
        }

        public int pop() {
            return stackUseQueue.removeLast();
        }

        public int top() {
            return stackUseQueue.getLast();
        }

        public boolean empty() {
            return stackUseQueue.isEmpty();
        }
    }
}
