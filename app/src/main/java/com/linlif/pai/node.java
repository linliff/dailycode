package com.linlif.pai;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by linlif on 2020/7/1
 */
class node {


    public static void main(String[] qq) {

//        ListNode.TreeNode sss1 = new ListNode.TreeNode(1);
//        ListNode.TreeNode sss1 = new ListNode.TreeNode(1);
//        ListNode.TreeNode sss1 = new ListNode.TreeNode(1);
//        ListNode.TreeNode sss1 = new ListNode.TreeNode(1);
//        ListNode.TreeNode sss1 = new ListNode.TreeNode(1);
//
//        sss1.next = sss2;
//        sss2.next = sss3;
//        sss3.next = sss4;
//        sss4.next = sss5;
//
//        reverseKGroup(sss1, 2);

    }


//    public static ListNode reverseKGroup(ListNode head, int k) {
//        ListNode cur = head;
//        int count = 0;
//        while (cur != null && count != k) {
//            cur = cur.next;
//            count++;
//        }
//        if (count == k) {
//            cur = reverseKGroup(cur, k);
//            while (count != 0) {
//                count--;
//                ListNode tmp = head.next;
//                head.next = cur;
//                cur = head;
//                head = tmp;
//            }
//            head = cur;
//        }
//        return head;
//    }
//
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        // 使用一个含有 len 个元素的最小堆，默认是最小堆，可以不写 lambda 表达式：(a, b) -> a - b
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        for (int i = 0; i < len; i++) {
//            minHeap.add(nums[i]);
//        }
//        for (int i = 0; i < len - k; i++) {
//            minHeap.poll();
//        }
//        return minHeap.peek();
//    }


}
