package com.linlif.leecode;

public class code325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;

    }

    private void checkRemove(TreeNode root, TreeNode parent, TreeNode node, int target, boolean isLeft) {

        if (parent == null || node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if (parent.left == null && parent.right == null) {
                removeLeafNodes(root, target);
            }
        } else if (node.left != null) {
            checkRemove(root, node, node.left, target, true);
        } else {
            checkRemove(root, node, node.right, target, false);
        }
    }
}
