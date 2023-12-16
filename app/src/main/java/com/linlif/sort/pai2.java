package com.linlif.sort;

/**
 * Created by linlif on 2020/5/9
 */
public class pai2 {

    public static void main(String[] qq) {

        int[] sss = new int[4];
        sss[0] = 4;
        sss[1] = 2;
        sss[2] = 3;
        sss[3] = 6;

        quicksort(sss);
    }

    private static void sort(int[] sss) {

        for (int i = 0; i < sss.length - 1; i++) {

            for (int j = 0; j < sss.length - 1 - i; j++) {

                if (sss[j] > sss[j + 1]) {

                    int temp = sss[j];
                    sss[j] = sss[j + 1];
                    sss[j + 1] = temp;

                }
            }
        }

        for (int i = 0; i < sss.length; i++) {

            System.out.println(sss[i]);
        }


    }

    private static void sort2(int[] sss) {

        for (int i = 0; i < sss.length - 1; i++) {

            int index = i;

            for (int j = i; j < sss.length; j++) {
                if (sss[index] > sss[j]) {
                    index = j;
                }
            }

            if (index != i) {
                int temp = sss[index];
                sss[index] = sss[i];
                sss[i] = temp;
            }
        }

        for (int i = 0; i < sss.length; i++) {

            System.out.println(sss[i]);
        }


    }

    private static void sort3(int[] sss) {

        for (int i = 0; i < sss.length - 1; i++) {

            int current = sss[i + 1];

            int aaa = i + 1;
            while (i >= 0 && current < sss[i]) {

                sss[i + 1] = sss[i];
                aaa = i;
                i--;

            }

            if (aaa != i) {
                sss[aaa] = current;
            }
        }

        for (int i = 0; i < sss.length; i++) {

            System.out.println(sss[i]);
        }


    }

    private static void quicksort(int[] arry) {


        quicksort(arry, 0, arry.length - 1);

        for (int i = 0; i < arry.length; i++) {

            System.out.println(arry[i]);
        }
    }

    private static void quicksort(int[] arry, int left, int right) {

        if (left < right) {

            int index = arry[left];

            int i = left;
            int j = right;

            while (i < j) {

                while (arry[j] >= index && i < j) {
                    j--;
                }

                while (arry[i] <= index && i < j) {
                    i++;
                }

                int temp = arry[j];
                arry[j] = arry[i];
                arry[i] = temp;
            }

            arry[left] = arry[i];
            arry[i] = index;
            quicksort(arry, left, j - 1);
            quicksort(arry, j + 1, right);

        }

    }

}
