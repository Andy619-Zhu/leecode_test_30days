package com.goo.test.listNode;

/**
 * @author Lenovo
 */
public class ReverseLinkedList {

    public void main() {

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
}
