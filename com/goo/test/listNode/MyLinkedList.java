package com.goo.test.listNode;

import learn_base.LearnListNode;
import org.junit.Test;

/**
 * 707 设计链表
 *
 * @author Lenovo
 */
public class MyLinkedList {

    //["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
    //[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]

    @Test
    public void test() {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);
//        int res = linkedList.get(1);
//        linkedList.deleteAtIndex(1);
//        int res1 = linkedList.get(1);
//        System.out.println(res);
//        print(head.next);

        linkedList.addAtHead(2);
        int res2 = linkedList.get(1);
        System.out.println(res2);
        linkedList.deleteAtIndex(1);

        linkedList.addAtHead(2);
        linkedList.addAtHead(7);
        linkedList.addAtHead(3);
        linkedList.addAtHead(2);
        linkedList.addAtHead(5);
        linkedList.addAtTail(5);

        int res3 = linkedList.get(5);
        System.out.println(res3);
        linkedList.deleteAtIndex(6);
        linkedList.deleteAtIndex(4);

    }

    static ListNode head;
    static int size;

    public MyLinkedList() {
        ListNode myListNode = new ListNode(-1);
        head = myListNode;
        size = 0;
    }

    public int get(int index) {
        ListNode head_temp = head;
        int res = -1;
        if (index > size || index < 0) {
            return res;
        } else {
            int tempindex = 0;
            while (tempindex <= index) {
                if (tempindex == index) {
                    res = head.next == null ? -1 : head.next.val;
                }
                head = head.next;
                tempindex++;
            }
        }
        head = head_temp;
        return res;
    }

    public void addAtHead(int val) {
        ListNode head_temp = head;
        ListNode atHead = new ListNode(val);
        if (size == 0) {
            head.next = atHead;
        } else {
            ListNode tempOne = head.next;
            head.next = atHead;
            atHead.next = tempOne;
        }
        size = size + 1;
        head = head_temp;

    }

    public void addAtTail(int val) {
        ListNode head_temp = head;
        ListNode atTail = new ListNode(val);
        while (head.next != null) {
            head = head.next;
        }
        head.next = atTail;
        size = size + 1;
        head = head_temp;

    }

    public void addAtIndex(int index, int val) {
        ListNode head_temp = head;
        ListNode atHead = new ListNode(val);
        if (index == size) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else if (index > size) {
            return;
        } else {
            int tempindex = 0;
            while (tempindex <= index) {
                if (tempindex == index) {
                    ListNode tempOne = head.next;
                    head.next = atHead;
                    atHead.next = tempOne;
                    size = size + 1;
                }
                head = head.next;
                tempindex++;
            }
            head = head_temp;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode head_temp = head;
        if (index < 0) {
            return;
        } else if (index >= size) {
            return;
        } else {
            int tempindex = 0;
            while (tempindex <= index) {
                if (tempindex == index) {
                    {
                        ListNode tempOne = head.next == null ? null : head.next.next;
                        head.next = tempOne;
                    }
                    size = size - 1;
                }
                tempindex++;
                head = head.next;
            }
            head = head_temp;
        }
    }

    //打印输出方法
    static void print(ListNode listNoed) {
        //创建链表节点
        while (listNoed != null) {
            System.out.println("节点:" + listNoed.val);
            listNoed = listNoed.next;
        }
        System.out.println();
    }

}
