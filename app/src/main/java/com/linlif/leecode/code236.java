package com.linlif.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 二叉树的最近公共祖先
 */
public class code236 {

    public static void main(String[] args) {

        int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};

        rotate(matrix);
//        TreeNode treeNode1 = new TreeNode(0);
//        TreeNode treeNode2 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(3);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(5);
//        TreeNode treeNode7 = new TreeNode(6);
//        TreeNode treeNode8 = new TreeNode(7);
//        TreeNode treeNode9 = new TreeNode(8);
//
//        treeNode4.left = treeNode6;
//        treeNode4.right = treeNode2;
//
//        treeNode6.left = treeNode7;
//        treeNode6.right = treeNode3;
//
//        treeNode3.left = treeNode8;
//        treeNode3.right = treeNode5;
//
//        treeNode2.left = treeNode1;
//        treeNode2.right = treeNode9;
//
//        lowestCommonAncestor(treeNode4, treeNode9, treeNode5);


    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                arrayList.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[arrayList.size()];
        for (int k = 0; k < arrayList.size(); k++) {

            result[k] = arrayList.get(k);
        }

        return result;

    }

    public int[] intersect2(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0) + 1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {

            Integer orDefault = hashMap.getOrDefault(nums2[i], 0);

            if (orDefault != 0) {
                arrayList.add(nums2[i]);
                hashMap.put(nums2[i], orDefault - 1);
            }
        }

        int[] result = new int[arrayList.size()];
        for (int k = 0; k < arrayList.size(); k++) {
            result[k] = arrayList.get(k);
        }

        return result;
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int length = matrix.length;
        //因为是对称的，只需要计算循环前半行即可
        for (int i = 0; i < length / 2; i++)
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                int m = length - j - 1;
                int n = length - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
    }
}
