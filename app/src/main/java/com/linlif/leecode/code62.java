package com.linlif.leecode;

public class code62 {

    public int uniquePaths(int m, int n) {

        if (m == 0 || n == 0) {
            return 1;
        }

        int[][] step = new int[m][n];
        step[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    step[i][j] = step[i - 1][j] + step[i][j - 1];
                } else if (i == 0 || j == 0) {
                    step[i][j] = 1;
                }
            }
        }
        return step[m - 1][n - 1];
    }
}
