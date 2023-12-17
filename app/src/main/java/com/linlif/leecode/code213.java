package com.linlif.leecode;

import java.util.Arrays;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 198. 打家劫舍II
 *
 * @author lifenglin
 * @date 2023/10/4
 */
public class code213 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        if (nums.length < 2) {
            return nums[0];
        }

        int shortResult = rob2(Arrays.copyOfRange(nums, 1, nums.length));
        int shortResult2 = rob2(Arrays.copyOfRange(nums, 0, nums.length - 1));

        int result = Math.max(shortResult, shortResult2);

        return result;
    }

    public int rob2(int[] nums) {
        int pre = 0, cur = 0, temp = 0;
        for (int i : nums) {
            temp = Math.max(cur, pre + i);
            pre = cur;
            cur = temp;
        }

        return temp;
    }

}
