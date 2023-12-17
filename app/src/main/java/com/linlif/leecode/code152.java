package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 152. 乘积最大子数组
 *
 * @author lifenglin
 * @date 2023/10/7
 */
public class code152 {

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int min = 1, max = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            result = Math.max(result, max);
        }
        return result;
    }

}
