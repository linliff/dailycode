package com.linlif.sort;

/**
 * Created by linlif on 2020/6/26
 */
class maopao {

    public static void main(String[] qq) {

        int[] sss = new int[4];
        sss[0] = 8;
        sss[1] = 2;
        sss[2] = 3;
        sss[3] = 6;

//        maopao1(sss);

        charu(sss);

        for (int i = 0; i < sss.length; i++) {
            System.out.println(sss[i] + "ccc ss   b  s  ");
        }
    }


    private static void maopao1(int[] sss) {

        if (sss == null || sss.length == 0) {
            return;
        }

        for (int i = 0; i < sss.length; i++) {

            for (int j = 0; j < sss.length - 1 - i; j++) {

                int temp;

                if (sss[j] > sss[j + 1]) {
                    temp = sss[j];
                    sss[j] = sss[j + 1];
                    sss[j + 1] = temp;
                }
            }
        }

    }


    private static void xuanze(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        int temp, minindex;

        for (int i = 0; i < array.length - 1; i++) {
            minindex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
            }

            if (minindex != i) {
                temp = array[i];
                array[i] = array[minindex];
                array[minindex] = temp;
            }
        }


    }


    private static void charu(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {

            int current = array[i + 1];
            int pos = i + 1;

            for (int j = i; j >= 0; j--) {

                if (current < array[j]) {

                    array[j + 1] = array[j];
                    pos = j;
                }
            }

            if (pos != i + 1) {
                array[pos] = current;
            }

        }

    }


}
