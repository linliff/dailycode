package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 198. 打家劫舍
 *
 * @author lifenglin
 * @date 2023/10/4
 */
public class code198 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        if (nums.length < 2) {
            return nums[0];
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int value1 = result[i - 2] + nums[i];
            int value2 = result[i - 1];
            result[i] = Math.max(value1, value2);
        }
        return result[nums.length - 1];
    }

    public int rob2(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = Math.max(pre + num, cur);
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
