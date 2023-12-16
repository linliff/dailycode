package com.linlif.leecode;

import java.util.ArrayList;

public class code872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        getList(root1, arrayList1);
        getList(root2, arrayList2);

        if (arrayList1.size() != arrayList2.size()) {
            return false;
        }

        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i) != arrayList2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getList(TreeNode treeNode, ArrayList<Integer> arrayList) {

        if (treeNode == null) {
            return;
        }

        if (treeNode.left == null && treeNode.right == null) {
            arrayList.add(treeNode.val);
        }
        getList(treeNode.left, arrayList);
        getList(treeNode.right, arrayList);
    }
}
