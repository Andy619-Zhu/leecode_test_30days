package com.goo.test.listNode;

import learn_base.LearnListNode;
import org.junit.Test;

import static com.goo.test.listNode.ListNode.print;

public class removeElements {

    @Test
    public void test() {

        int[] head1 = {1, 2, 6, 3, 4, 5, 6};
        int[] head = {6, 6, 6, 6, 6, 6, 6};
        ListNode nodeSta = new ListNode(head[0]);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                      //指向首节点

        //创建链表
        for (int i = 1; i < 7; i++) {
            ListNode node = new ListNode(head[i]);  //生成新的节点
            nextNode.next = node;               //把心节点连起来
            nextNode = nextNode.next;           //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，
        nextNode = nodeSta;

        print(nextNode);

        ListNode res = removeElements1(nextNode, 7);
        System.out.println("***************");
        print(res);


    }

    public ListNode removeElements1(ListNode head, int val) {

        if (head == null) {
            return head;
        }


        ListNode nodeSta = new ListNode(-1);          //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                      //指向首节点

        while (head != null) {
            if (head.val == val) {
                head = head.next;
                continue;
            } else {
                nextNode.next = new ListNode(head.val);               //把心节点连起来
                nextNode = nextNode.next;           //当前节点往后移动
                head = head.next;
            }

        }
        head = nodeSta;
        return head.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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