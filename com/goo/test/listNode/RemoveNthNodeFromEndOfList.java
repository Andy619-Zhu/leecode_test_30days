package com.goo.test.listNode;

import org.junit.Test;

/**
 * 19
 *
 * @author Lenovo
 */
public class RemoveNthNodeFromEndOfList {

    @Test
    public void test() {
        ListNode nodeSta = new ListNode(0);          //创建首节点
        ListNode nextNode;                           //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                            //指向首节点

        //创建链表
        for (int i = 1; i < 1; i++) {
            ListNode node = new ListNode(i);         //生成新的节点
            nextNode.next = node;                      //把心节点连起来
            nextNode = nextNode.next;                  //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode = nodeSta;                            //重新赋值让它指向首节点
        print(nextNode);                             //打印输出
        ListNode res = removeNthFromEnd(nextNode, 1);
        print(res);

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode reversOne = reverseList(head);
        ListNode myNode = new ListNode(-1);
        myNode.next = reversOne;

        while (n >= 0) {
            if (n == 1) {
                myNode.next = reversOne.next;
                break;
            }
            if (n == 2) {
                reversOne.next = reversOne.next.next;
                break;
            }
            n--;
            reversOne = reversOne.next;
        }
        ListNode myNodeRes = reverseList(myNode.next);
        return myNodeRes;
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;

        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = result;
            result = temp;
            head = head.next;
        }
        return result;
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
