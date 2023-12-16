package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

public class code589 {

    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        addValue(result, root);
        return result;
    }

    private void addValue(List<Integer> result, Node node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        List<Node> children = node.children;
        if (children == null || children.isEmpty()) {
            return;
        }
        for (Node node1 : children) {
            addValue(result, node1);
        }
    }

}
