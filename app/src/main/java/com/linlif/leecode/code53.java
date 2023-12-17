package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 53. 最大子数组和
 *
 * @author lifenglin
 * @date 2023/10/5
 */
public class code53 {

    public static void main(String[] args) {

        int[] aaa = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(aaa);
    }

    //[-2,1,-3,4,-1,2,1,-5,4]
    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(nums[i] + temp, nums[i]);
            max = Math.max(max, temp);
        }
        return max;
    }
}
