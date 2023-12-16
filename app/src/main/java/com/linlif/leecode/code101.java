package com.linlif.leecode;

public class code101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isSame(root.left, root.right);

    }

    private boolean isSame(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
