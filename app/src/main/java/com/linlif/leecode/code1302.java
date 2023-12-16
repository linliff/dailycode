package com.linlif.leecode;

public class code1302 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;

        treeNode4.left = treeNode7;

        treeNode6.right = treeNode8;

        deepestLeavesSum(treeNode1);
    }

    static int maxIndex = 0;
    static int result = 0;

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getValue(root, 0);
        return result;
    }

    private static void getValue(TreeNode node, int index) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (index > maxIndex) {
                result = node.val;
                maxIndex = index;
            } else if (index == maxIndex) {
                result += node.val;
            }
        } else {
            maxIndex = Math.max(maxIndex, index);
        }
        getValue(node.left, index + 1);
        getValue(node.right, index + 1);

    }


}
