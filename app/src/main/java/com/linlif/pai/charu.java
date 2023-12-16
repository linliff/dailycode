package com.linlif.pai;


/**
 * Created by linlif on 2020/7/13
 */
public class charu {

    public static void main(String[] qq) {

        int[] sss = new int[]{1, 8, 2, 4, 5, 0};
        sort3(sss);

        for (int value : sss) {

            System.out.println(value + "cc");
        }
    }

    public static void sort3(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int current = array[i + 1];
            int next = i + 1;

            for (int j = i; j >= 0; j--) {

                if (array[j] > current) {
                    array[j + 1] = array[j];
                    next = j;
                }
            }
            array[next] = current;
        }

    }

}
