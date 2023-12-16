package com.linlif.pai;


/**
 * Created by linlif on 2020/7/13
 */
public class maopao {

    public static void main(String[] qq) {

        int[] sss = new int[]{8, 2, 4, 5, 0};
        sort3(sss);

        for (int value : sss) {

            System.out.println(value + "cc");
        }
    }

    public static void sort3(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

}
