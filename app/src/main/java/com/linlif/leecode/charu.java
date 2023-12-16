package com.linlif.leecode;

public class charu {

    public static void main(String[] qq) {

        int[] sss = new int[]{2, 1, 3, 343, 56459, 133};

        charu(sss);

        for (int i = 0; i < sss.length; i++) {
            System.out.println(sss[i] + "ccc ss   b  s  ");
        }
    }

    private static void charu(int[] array) {

        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int temp = i;

            while (temp >= 0 && current < array[temp]) {
                array[temp + 1] = array[temp];
                temp--;
            }

            array[temp + 1] = current;
        }


    }
}
