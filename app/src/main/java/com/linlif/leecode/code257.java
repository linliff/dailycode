package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/11/12
 */
public class code257 {

    ArrayList<String> arrayList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return arrayList;
        }

        addValue(root, "");

        return arrayList;
    }

    private void addValue(TreeNode treeNode, String element) {
        if (treeNode == null) {
            return;
        }

        StringBuffer stringBuffer = new StringBuffer(element);
        if (element.length() == 0) {
            stringBuffer.append(treeNode.val);
        } else {
            stringBuffer.append("->").append(treeNode.val);
        }
        if (treeNode.left == null && treeNode.right == null) {
            arrayList.add(stringBuffer.toString());
        }

        addValue(treeNode.left, stringBuffer.toString());
        addValue(treeNode.right, stringBuffer.toString());

    }

}
