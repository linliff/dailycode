package com.linlif.leecode;

public class NumArray {

    private int sums[];

    public NumArray(int[] nums) {

        sums = new int[nums.length + 1];

        sums[0] = nums[0];
        for (int i = 1; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + sums[i - 1];
        }
    }

    public int sumRange(int left, int right) {

        return sums[right + 1] - sums[left];
    }

    private int[][] preNums;

//    public NumMatrix(int[][] matrix) {
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        if (m == 0 || n == 0) {
//            return;
//        }
//
//        preNums = new int[m + 1][n + 1];
//        for (int i = 1; i < m + 1; i++) {
//
//            for (int j = 1; j < n + 1; j++) {
//                preNums[i][j] = preNums[i - 1][j] + preNums[i][j - 1] + matrix[i - 1][j - 1] - preNums[i - 1][j - 1];
//            }
//        }
//    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return preNums[row2 + 1][col2 + 1] - preNums[row1][col2 + 1] - preNums[row2 + 1][col1] + preNums[row1][col1];
    }
}
