package com.linlif.pai;


/**
 * Created by linlif on 2020/7/13
 */
public class kuaisu {

    public static void main(String[] qq) {

        int[] sss = new int[]{2, 7, 3, 1, 5, 2, 766, 33, 21, 121};
        sort3(sss);

        for (int value : sss) {

            System.out.println(value + "cc");
        }
    }

    public static void sort3(int[] array) {

        quick(array, 0, array.length - 1);

    }

    private static void quick(int[] array, int left, int right) {

        if (left < right) {
            int index = array[left];

            int i = left;
            int j = right;

            while (i < j) {
                while (array[j] >= index && j > i) {
                    j--;
                }

                while (array[i] <= index && j > i) {
                    i++;
                }

                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }

            array[left] = array[i];
            array[i] = index;

            quick(array, left, j - 1);
            quick(array, j + 1, right);

        }


    }

}
