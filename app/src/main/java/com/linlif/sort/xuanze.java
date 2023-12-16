package com.linlif.sort;

public class xuanze {

    public static void main(String[] qq) {

        int[] sss = new int[]{2, 1, 3, 343, 56459, 133};

        xuanze(sss);

        for (int i = 0; i < sss.length; i++) {
            System.out.println(sss[i] + "ccc ss   b  s  ");
        }
    }

    private static void xuanze(int[] array) {

        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i ; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }


    }
}
