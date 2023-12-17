package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/11/5
 */
public class code965 {

    public boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return false;
        }

        return isSameValue(root, root.val);
    }

    private boolean isSameValue(TreeNode node, int value) {
        if (node == null) {
            return true;
        }

        if (node.val == value) {
            boolean right = isSameValue(node.right, value);
            boolean left = isSameValue(node.left, value);
            return right && left;
        }

        return false;

    }

}
