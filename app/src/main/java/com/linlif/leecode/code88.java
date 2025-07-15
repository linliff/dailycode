package com.linlif.leecode;

/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2025/1/19
 */
public class code88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = nums1.length;

        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i - 1] = nums1[m - 1];
                i--;
                m--;
            } else {
                nums1[i - 1] = nums2[n - 1];
                i--;
                n--;
            }

        }
    }
}