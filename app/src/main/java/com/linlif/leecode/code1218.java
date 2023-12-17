package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 * 1218. Longest Arithmetic Subsequence of Given Difference
 *
 * @author lifenglin
 * @date 2023/10/16
 */
public class code1218 {

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            int pre = arr[i];
            int length = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (pre + difference == arr[j]) {
                    pre = arr[j];
                    length++;
                }
            }
            result = Math.max(length, result);
        }
        return result;

    }
}
