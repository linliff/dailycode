package com.linlif.leecode;

public class code814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    private boolean isInvalid(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }

        if (treeNode.left == null && treeNode.right == null) {
            return treeNode.val == 0;
        }
        boolean left = isInvalid(treeNode.left);
        if (left) {
            treeNode.left = null;
        }
        boolean right = isInvalid(treeNode.right);

        if (right) {
            treeNode.right = null;
        }

        return left && right;
    }
}
