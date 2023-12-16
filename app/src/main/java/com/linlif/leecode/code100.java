package com.linlif.leecode;

public class code100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkSame(p, q);
    }

    private boolean checkSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        boolean left = checkSame(p.left, q.left);
        boolean right = checkSame(p.right, q.right);
        return left && right;
    }
}
