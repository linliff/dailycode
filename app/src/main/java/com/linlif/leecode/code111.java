package com.linlif.leecode;

public class code111 {

//    叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
//    当 root 节点左右孩子都为空时，返回 1
//    当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
//    当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftIndex = minDepth(root.left);
        int rightIndex = minDepth(root.right);

        if (root.left == null || root.right == null) return leftIndex + rightIndex + 1;

        return Math.min(leftIndex, rightIndex) + 1;
    }

}
