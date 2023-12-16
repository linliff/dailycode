package com.linlif.sort;

/**
 * Created by linlif on 2020/5/8
 */
public class pai {

    public static void main(String[] qq) {

        int[] sss = new int[4];
        sss[0] = 8;
        sss[1] = 2;
        sss[2] = 3;
        sss[3] = 6;

        sort3(sss);
    }


    public static void sort(int[] array) {

        for (int j = 0; j < array.length - 1; j++) {

            for (int i = 0; i < array.length - 1 - j; i++) {

                int temp;
                if (array[i] > array[i + 1]) {

                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }


        for (int value : array) {

            System.out.println(value + "cc");
        }
    }

    public static void sort2(int[] array) {

        int temp, minindex;

        for (int i = 0; i < array.length; i++) {
            minindex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    minindex = j;
                }
            }

            if (minindex != i) {
                temp = array[i];
                array[i] = array[minindex];
                array[minindex] = temp;
            }
        }

        for (int i = 0; i < array.length; i++) {

            System.out.println(array[i] + "cc");
        }
    }


    public static void sort3(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];

            int aaa = i + 1;
            for (int j = i; j >= 0; j--) {

                if (current < array[j]) {

                    array[j + 1] = array[j];
                    aaa = j;
                }

            }

            array[aaa] = current;
        }

        for (int i = 0; i < array.length; i++) {

            System.out.println(array[i] + "cc");
        }

    }


}
