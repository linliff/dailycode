package com.linlif.leecode;

public class code63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] steps = new int[m][n];

        if (obstacleGrid[0][0] == 1) {
            steps[0][0] = 0;
        } else {
            steps[0][0] = 1;
        }
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    steps[i][j] = 0;
                } else if (i > 0 && j > 0) {
                    steps[i][j] = steps[i-1][j] + steps[i][j - 1];
                } else if (j > 0) {
                    steps[i][j] = steps[i][j - 1];
                } else if (i > 0) {
                    steps[i][j] = steps[i - 1][j];
                }
            }
        }
        return steps[m - 1][n - 1];

    }
}
