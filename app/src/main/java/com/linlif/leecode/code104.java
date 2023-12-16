package com.linlif.leecode;

/**
 * 二叉树最大深度
 */
public class code104 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return deepSize(root, 1);
    }


    public int deepSize(TreeNode root, int size) {

        if (root == null) {
            return 0;
        }

        int left = deepSize(root.left, size) + size;
        int right = deepSize(root.right, size)+ size;

        return Math.max(left, right);
    }
}
