package com.linlif.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/11/5
 */
public class code107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        addToList(root, lists, 0);
        Collections.reverse(lists);
        return lists;
    }

    private void addToList(TreeNode treeNode, ArrayList<List<Integer>> lists, int index) {

        if (treeNode == null) {
            return;
        }
        if (lists.size() <= index) {
            lists.add(new ArrayList<Integer>());
        }

        List<Integer> integers = lists.get(index);
        integers.add(treeNode.val);

        addToList(treeNode.left, lists, index + 1);
        addToList(treeNode.right, lists, index + 1);

    }

}
