package com.linlif.leecode;

/**
 * 最大自序和
 */
public class code53 {

    public static void main(String[] args) {

    }


    public int maxSubArray(int[] nums) {

        int current = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            current = Math.max(current, sum);
        }

        return current;
    }
}
