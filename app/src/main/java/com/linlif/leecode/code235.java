package com.linlif.leecode;

import java.util.ArrayList;

public class code235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> leftList = new ArrayList<>();
        ArrayList<TreeNode> rightList = new ArrayList<>();

        getPath(leftList, root, p);
        getPath(rightList, root, q);

        return findSame(leftList, rightList);
    }

    private void getPath(ArrayList<TreeNode> pathList, TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        pathList.add(root);
        if (root.val > p.val) {
            getPath(pathList, root.left, p);
        } else if (root.val < p.val) {
            getPath(pathList, root.right, p);
        }
    }

    private TreeNode findSame(ArrayList<TreeNode> leftList, ArrayList<TreeNode> rightList) {
        TreeNode treeNode = null;
        for (int i = 0; i < leftList.size() && i < rightList.size(); ++i) {
            if (leftList.get(i) == rightList.get(i)) {
                treeNode = leftList.get(i);
            } else {
                break;
            }
        }
        return treeNode;

    }


}
