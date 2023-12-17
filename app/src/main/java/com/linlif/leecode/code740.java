package com.linlif.leecode;

import java.util.Arrays;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 740. 删除并获得点数
 *
 * @author lifenglin
 * @date 2023/10/5
 */
public class code740 {

    public static void main(String[] args) {

        int[] aaa = new int[]{3, 3, 4};
        deleteAndEarn(aaa);
    }

    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int[] dp = new int[nums[nums.length - 1] + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] += nums[i];
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}
