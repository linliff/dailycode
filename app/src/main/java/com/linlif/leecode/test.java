package com.linlif.leecode;

import java.math.BigDecimal;

/**
 * Created by linlif on 2020/5/8
 */
public class test {

    public static void main(String[] qq) {


        double maxProportion = 51 / (double) 35;
        System.out.println(maxProportion + "cc ");


        double num = Math.round((float) 51 / 35);

        double f1 = new BigDecimal((float) 51 / 35).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        System.out.println(f1 + "asasss");


    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int current = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            current = Math.max(sum, current);
        }
        return current;
    }

    private void quick(int[] array) {


        quick(array, 0, array.length - 1);

    }

    private void quick(int[] array, int left, int right) {

        if (left < right) {

            int index = array[left];

            int i = left;
            int j = right;

            while (i < j) {

                while (j > i && array[j] >= index) {
                    j--;
                }

                while (i < j && array[i] <= index) {
                    i++;
                }

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

            array[left] = array[i];
            array[i] = index;

            quick(array, left, j - 1);
            quick(array, j + 1, right);

        }


    }

}
