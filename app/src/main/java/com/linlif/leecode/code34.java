package com.linlif.leecode;

public class code34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midNum = nums[mid];
            if (target == midNum) {
                int left1 = mid;
                int right1 = mid;
                result[0] = mid;
                result[1] = mid;

                while (left1 >= 0) {
                    left1--;
                    if (left1 >= 0 && nums[left1] == target) {
                        result[0] = left1;
                    } else {
                        left1 = -1;
                    }
                }
                while (right1 < nums.length) {
                    right1++;
                    if (right1 < nums.length && nums[right1] == target) {
                        result[1] = right1;
                    } else {
                        right1 = nums.length;
                    }
                }
                break;
            } else if (target > midNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (result[0] != -1 && result[1] == -1) {
            result[1] = result[0];
        }

        return result;
    }
}
