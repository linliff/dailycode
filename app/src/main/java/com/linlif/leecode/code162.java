package com.linlif.leecode;

/**
 * 数组峰值的位置
 */
public class code162 {

    public static void main(String[] args) {
        int[] nums = {1, 6,5,8,5};

        int peakElement = findPeakElement(nums);

        System.out.println(peakElement);

    }

    public static int findPeakElement(int[] nums) {

        if (nums == null) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return nums.length - 1;
    }

}
