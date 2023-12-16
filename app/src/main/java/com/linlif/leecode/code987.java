package com.linlif.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code987 {

    public void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode6;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode7;
        verticalTraversal(treeNode1);
    }

    //     HashMap<Integer, List<PosNode>> map = new HashMap<Integer, List<PosNode>>();
    Map<TreeNode, int[]> map = new HashMap<>();

    int minCol;
    int maxCol;

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        getValue(root, 0, 0);

        List<int[]> list = new ArrayList<>(map.values());
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                return o1[2] - o2[2];
            }
        });


        int n = list.size();
        for (int i = 0; i < n; ) {
            int j = i;
            List<Integer> tmp = new ArrayList<>();
            while (j < n && list.get(j)[1] == list.get(i)[1]) tmp.add(list.get(j++)[2]);
            lists.add(tmp);
            i = j;
        }

        for (int j = minCol + 1; j <= maxCol - 1; j++) {

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[1] == j) {
                    temp.add(list.get(i)[2]);
                }
            }
            lists.add(temp);
        }

        return lists;

    }

    private void getValue(TreeNode node, int row, int col) {
        if (node == null) {
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            return;
        }
        map.put(node, new int[]{row, col, node.val});
        getValue(node.left, row + 1, col - 1);
        getValue(node.right, row + 1, col + 1);
    }

}
