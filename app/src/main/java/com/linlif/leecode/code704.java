package com.linlif.leecode;

public class code704 {


    public int search(int[] nums, int target) {
        int index = -1;
        if (nums == null || nums.length == 0) {
            return index;
        }

        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;

    }
}
