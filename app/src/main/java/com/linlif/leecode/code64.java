package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/10/19
 */
public class code64 {

    private int minPath(int[][] grid) {

        if (grid == null) {
            return 0;
        }

        int mLength = grid.length;
        int nLength = grid[0].length;

        int[][] minPath = new int[mLength][nLength];

        minPath[0][0] = grid[0][0];

        for (int i = 0; i < mLength; i++) {

            for (int j = 0; j < nLength; j++) {
                if (i > 0 && j > 0) {
                    minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    minPath[i][j] = grid[i][j] + minPath[i - 1][j];
                } else if (j > 0) {
                    minPath[i][j] = grid[i][j] + minPath[i][j - 1];
                }
            }
        }

        return minPath[mLength - 1][nLength - 1];

    }

}
