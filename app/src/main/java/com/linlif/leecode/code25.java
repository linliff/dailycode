package com.linlif.leecode;

/**
 * K 个一组翻转链表
 */
public class code25 {

    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode node, int k) {

        if (node == null || node.next == null) {
            return node;
        }
        ListNode tail = node;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return node;
            }
            tail = tail.next;
        }

        ListNode newHead = reverse(node, tail);
        node.next = reverseKGroup(tail, k);

        return newHead;

    }

    private static ListNode reverse(ListNode head, ListNode tail) {

        ListNode pre = null;
        ListNode next = null;

        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }


}
