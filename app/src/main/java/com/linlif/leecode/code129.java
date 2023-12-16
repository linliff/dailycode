package com.linlif.leecode;

public class code129 {

    public int sumNumbers(TreeNode root) {

        return getOneSum(root, 0);
    }

    private int getOneSum(TreeNode treeNode, int beforeSum) {
        if (treeNode == null) {
            return beforeSum;
        }
        beforeSum = beforeSum * 10 + treeNode.val;

        if (treeNode.left == null && treeNode.right == null) {
            return beforeSum;
        }
        int left = getOneSum(treeNode.left, beforeSum);
        int right = getOneSum(treeNode.right, beforeSum);

        return left + right;
    }
}
