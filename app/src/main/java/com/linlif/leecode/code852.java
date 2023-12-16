package com.linlif.leecode;

public class code852 {

    public int peakIndexInMountainArray(int[] arr) {

        int result = -1;
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mindIndex = (right - left) / 2 + left;
            int mid = arr[mindIndex];
            if (mindIndex == 0) {
                return mindIndex + 1;
            }
            if (mindIndex == arr.length - 1) {
                return mindIndex - 1;
            }
            int leftValue = arr[mindIndex - 1];
            int rightValue = arr[mindIndex + 1];
            if (mid > leftValue && mid > rightValue) {
                result = mindIndex;
                return result;
            } else if (mid > leftValue && mid < rightValue) {
                left = mindIndex + 1;
            } else {
                right = mindIndex - 1;
            }
        }

        return result;

    }
}
