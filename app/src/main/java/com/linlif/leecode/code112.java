package com.linlif.leecode;

public class code112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return isTargetSum(root, targetSum, 0);

    }


    private boolean isTargetSum(TreeNode treeNode, int targetSum, int beforeSum) {
        if (treeNode == null) {
            return false;
        }

        if (treeNode.left == null && treeNode.right == null
                && targetSum == beforeSum + treeNode.val) {
            return true;
        }

        boolean left = isTargetSum(treeNode.left, targetSum, beforeSum + treeNode.val);
        boolean right = isTargetSum(treeNode.right, targetSum, beforeSum + treeNode.val);
        return left || right;

    }
}
