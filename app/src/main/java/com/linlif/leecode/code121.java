package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2023/10/19
 */
public class code121 {


    private int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                result = Math.max(result, prices[i] - min);
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return result;
    }

}
