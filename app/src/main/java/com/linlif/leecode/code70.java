package com.linlif.leecode;

/**
 * 爬楼梯
 */
public class code70 {

    public static void main(String[] args) {

    }


    public int climbStairs(int n) {

        int[] size = new int[n + 1];

        size[0] = 1;
        size[1] = 1;

        for (int i = 2; i <= n; i++) {
            size[i] = size[i - 1] + size[i - 2];
        }

        return size[n];
    }
}
