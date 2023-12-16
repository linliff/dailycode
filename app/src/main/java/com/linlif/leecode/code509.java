package com.linlif.leecode;

/**
 * 斐波那契数
 */
public class code509 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int result = 0;
        int p = 0, q = 1;
        for (int i = 2; i <= n; i++) {
            result = p + q;
            p = q;
            q = result;
        }
        return result;
    }
}
