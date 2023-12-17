package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 45. 跳跃游戏 II
 *
 * @author lifenglin
 * @date 2023/10/5
 */
public class code45 {

    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxpos = 0;
        int step = 0;

        for (int i = 0; i < len - 1; i++) {
            maxpos = Math.max(maxpos, i + nums[i]);
            if (i == end) {
                end = maxpos;
                step++;
            }
        }
        return step;

    }
}
