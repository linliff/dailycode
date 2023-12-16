package com.linlif.leecode;

public class code304 {


    private class NumMatrix {

        int[][] sum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            if (m > 0) {
                sum = new int[m][n + 1];
            }

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {
                    sum[i][j + 1] = sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int result = 0;
            for (int i = row1; i <= row2; i++) {
                result += sum[i][col2 + 1] - sum[i][col1];
            }
            return result;
        }
    }

}
