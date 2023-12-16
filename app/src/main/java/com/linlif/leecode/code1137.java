package com.linlif.leecode;

/**
 * 1137. 第 N 个泰波那契数
 */
public class code1137 {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int result = 0;
        int p = 0, q = 1, w = 1;
        for (int i = 3; i <= n; i++) {
            result = p + q + w;
            p = q;
            q = w;
            w = result;
        }
        return result;
    }
}
