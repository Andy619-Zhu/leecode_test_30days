package com.goo.test.listNode;

import org.junit.Test;

/**
 * 面试题02.07
 *
 * @author Lenovo
 */
public class IntersectionOfTwoLinkedListsLcci {

    @Test
    public void test() {
        ListNode nodeSta = new ListNode(0);          //创建首节点
        ListNode nextNode;                           //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                            //指向首节点

        //创建链表
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i);         //生成新的节点
            nextNode.next = node;                      //把心节点连起来
            nextNode = nextNode.next;                  //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode = nodeSta;                            //重新赋值让它指向首节点
        print(nextNode);                             //打印输出

        ListNode nodeSta1 = new ListNode(7);          //创建首节点
        ListNode nextNode1;                           //声明一个变量用来在移动过程中指向当前节点
        nextNode1 = nodeSta1;                            //指向首节点

        //创建链表
        for (int i = 9; i < 15; i++) {
            ListNode node = new ListNode(i);         //生成新的节点
            nextNode1.next = node;                      //把心节点连起来
            nextNode1 = nextNode1.next;                  //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode1 = nodeSta1;                            //重新赋值让它指向首节点
        print(nextNode1);                             //打印输出


        System.out.println(getListNodeSize(nextNode));
        System.out.println(getListNodeSize(nextNode1));

        print(getIntersectionNode(nextNode, nextNode1));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getListNodeSize(headA);
        int sizeB = getListNodeSize(headB);
        int delta = sizeA - sizeB;
        if (delta < 0) {
            while (Math.abs(delta) != 0) {
                headB = headB.next;
                delta++;
            }
        } else {
            while (Math.abs(delta) != 0) {
                headA = headA.next;
                delta--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int getListNodeSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
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
