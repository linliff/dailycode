package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/11/4
 */
public class code572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null ) {
            return false;
        }

        return containsSun(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public boolean containsSun(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }
        if (node == null || subNode == null || node.val != subNode.val) {
            return false;
        }

        boolean right = containsSun(node.right, subNode.right);
        boolean left = containsSun(node.left, subNode.left);
        return left && right;

    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

}
