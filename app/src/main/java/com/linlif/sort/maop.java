package com.linlif.sort;

public class maop {

    public static void main(String[] qq) {

        int[] sss = new int[]{2,1,3,343,56459,133};


        maop(sss);

        for (int i = 0; i < sss.length; i++) {
            System.out.println(sss[i] + "ccc ss   b  s  ");
        }
    }

    private static void maop(int[] array) {

        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }

        }


    }
}
