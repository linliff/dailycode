package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 爬楼梯
 *
 * @author lifenglin
 * @date 2023/9/28
 */
public class code70 {

    public int climbStair(int n) {
        if (n <= 1) {
            return 1;
        }

        int result = 0;
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {
            result = p + q;
            p = q;
            q = result;
        }
        return result;
    }
}
