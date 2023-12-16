package com.linlif.leecode;

public class code35 {

    public int searchInsert(int[] nums, int target) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
            index = i + 1;
        }

        return index;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target <= nums[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
