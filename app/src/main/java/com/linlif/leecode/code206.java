package com.linlif.leecode;

/**
 * 反转链表
 */
public class code206 {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return current;

    }

    public static ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        ListNode current = head;
        ListNode temp = null;

        while (current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        return pre;

    }


}
