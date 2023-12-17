package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 746. 使用最小花费爬楼梯
 *
 * @author lifenglin
 * @date 2023/10/4
 */
public class code746 {

    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length <= 1) {
            return 0;
        }
        int[] result = new int[cost.length + 1];
        result[0] = 0;
        result[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            int cost1 = result[i - 1] + cost[i - 1];
            int cost2 = result[i - 2] + cost[i - 2];
            result[i] = Math.min(cost1, cost2);
        }
        return result[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length <= 1) {
            return 0;
        }

        int pre = 0, cur = 0, temp = 0;
        for (int i = 2; i <= cost.length; i++) {
            temp = Math.min(pre + cost[i - 2], cur + cost[i - 1]);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
