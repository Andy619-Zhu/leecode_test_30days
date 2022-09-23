package com.goo.test.listNode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 142
 *
 * @author Lenovo
 */
public class LinkedListCycleIi {

    @Test
    public void test() {
        ListNode nodeSta = new ListNode(0);          //创建首节点
        ListNode nextNode;                           //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                            //指向首节点

        //创建链表
        for (int i = 1; i < 4; i++) {
            ListNode node = new ListNode(i);         //生成新的节点
            nextNode.next = node;                      //把心节点连起来
            nextNode = nextNode.next;                  //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode.next = nodeSta;                            //重新赋值让它指向首节点
//        print(nextNode);                             //打印输出
        ListNode myNode = new ListNode(-1);
        myNode.next = nextNode;
        ListNode res = detectCycle(myNode);

        print(res);
    }


    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        int setSize = -1;
        if (sureCycle(head)) {
            while (head != null) {
                set.add(head);
                if (set.size() == setSize) {
                    return head;
                }
                setSize = set.size();
                head = head.next;
            }
        }
        return null;
    }

    public boolean sureCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (head.next != null && head.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
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
