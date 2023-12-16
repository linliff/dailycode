package com.linlif.leecode;


/**
 * 翻转二叉树
 */
public class code226 {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            if (root.left != null) {
                invertTree(root.left);
            }

            if (root.right != null) {
                invertTree(root.right);
            }
        }
        return root;
    }

}
