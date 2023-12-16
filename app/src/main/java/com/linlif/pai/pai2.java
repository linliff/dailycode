package com.linlif.pai;

/**
 * Created by linlif on 2020/5/9
 */
public class pai2 {

    public static void main(String[] qq) {

        int[] sss = new int[]{2,7,3,1,5,2,766,33,21,121};

        quicksort(sss);
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
            quicksort(arry, left, i - 1);
            quicksort(arry, i + 1, right);

        }

    }

    /**
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     */
    public static int aaa(int nums) {

        int[] aa = new int[nums + 1];

        aa[0] = 1;
        aa[1] = 1;

        for (int i = 2; i <= nums; i++) {

            aa[i] = aa[i - 1] + aa[i - 2];
        }

        return aa[nums];

    }

}
