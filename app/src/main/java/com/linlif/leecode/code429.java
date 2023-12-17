package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/10/29
 */
public class code429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        addValue(result, root, 1);
        return result;
    }


    private void addValue(List<List<Integer>> result, Node node, int index) {
        if (node == null) {
            return;
        }

        if (result.size() < index) {
            result.add(new ArrayList<Integer>());
        }

        List<Integer> integers = result.get(index - 1);
        integers.add(node.val);
        addChildValue(result, node.children, index + 1);

    }

    private void addChildValue(List<List<Integer>> result, List<Node> childNode, int index) {
        if (childNode == null || childNode.isEmpty()) {
            return;
        }

        for (Node node : childNode) {
            addValue(result, node, index);
        }

    }

}
