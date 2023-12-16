package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class code144 {

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        bianli(arrayList, root);
        return arrayList;
    }


    public void bianli(ArrayList<Integer> list, TreeNode root) {

        if (root == null || list == null) {
            return;
        }

        list.add(root.val);
        bianli(list, root.left);
        bianli(list, root.right);

    }
}
