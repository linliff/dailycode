package com.linlif.pai;


/**
 * Created by linlif on 2020/7/13
 */
public class xuanze {

    public static void main(String[] qq) {

        int[] sss = new int[]{1, 8, 2, 4, 5, 0};
        sort3(sss);

        for (int value : sss) {

            System.out.println(value + "cc");
        }
    }

    public static void sort3(int[] array) {

        int current;
        int min;
        for (int i = 0; i < array.length - 1; i++) {

            current = array[i];
            min = i;
            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < current) {
                    min = j;
                }

            }

            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }

    }

}
