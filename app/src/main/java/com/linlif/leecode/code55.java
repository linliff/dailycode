package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 55. 跳跃游戏
 *
 * @author lifenglin
 * @date 2023/10/5
 */
public class code55 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int end = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= end) {
                end = i;
            }
        }
        return end == 0;

    }

}
