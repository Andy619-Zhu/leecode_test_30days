package com.goo.test.StackAndQueue;

/**
 * @author Lenovo
 */
public class myQueueTest {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int peek = queue.peek();  // 返回 1
        System.out.println(peek);
        int pop = queue.pop();   // 返回 1
        System.out.println(pop);
        boolean em = queue.empty(); // 返回 false
        System.out.println(em);


//        ImplementStackUsingQueues.MyStack myStack = new ImplementStackUsingQueues.MyStack();



    }
}
