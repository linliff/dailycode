package com.linlif.leecode;

public class code700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
        TreeNode right = searchBST(root.right, val);
        return right;
    }


}
