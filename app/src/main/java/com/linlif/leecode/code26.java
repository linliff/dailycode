package com.linlif.leecode;

/**
 * 删除排序数组中的重复项
 */
public class code26 {

    public static void main(String[] args) {

    }


    public int removeDuplicates(int[] nums) {

        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p] != nums[i]) {
                nums[p + 1] = nums[i];
                p++;
            }
        }

        return p + 1;
    }
}
