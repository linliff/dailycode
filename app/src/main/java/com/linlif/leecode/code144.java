package com.linlif.leecode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 前序遍历
 *
 * @author lifenglin
 * @date 2023/9/25
 */
public class code144 {


    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode5.left = treeNode6;

        System.out.println("hello");
        testttt();
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        if (root != null) {
            stk.push(root);
        }

        while (!stk.isEmpty()) {
            TreeNode pop = stk.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stk.push(pop.right);
            }
            if (pop.left != null) {
                stk.push(pop.left);
            }
        }
        return res;
    }


    public static void testttt() {

        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        res.add(2);
        res.add(3);
        res.add(4);
        res.add(5);

        ListIterator<Integer> iterator = res.listIterator();
        while (iterator.hasPrevious()) {
            Integer current = iterator.next();
            System.out.println(
                    "current = " + current + " nextIndex = " + iterator.nextIndex() + " previousIndex = " + iterator
                            .previousIndex());
        }

        System.out.println("end");

    }
}


