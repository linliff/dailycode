package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 1567. 乘积为正数的最长子数组长度
 *
 * @author lifenglin
 * @date 2023/10/7
 */
public class code1567 {

    public int getMaxLen(int[] nums) {
        int result = 0;
        int min = 1, max = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
//            if ()
            result = Math.max(result, max);
        }
        return result;
    }

}
