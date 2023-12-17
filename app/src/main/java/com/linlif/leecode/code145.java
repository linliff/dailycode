package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/10/29
 */
public class code145 {

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

        postorderTraversal(treeNode1);
    }


    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        addResult(result, root);
        return result;
    }

    private static void addResult(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("addResult : " + node.val);

        addResult(result, node.left);
        addResult(result, node.right);
        result.add(node.val);
        System.out.println("add : " + node.val);

    }
}
