package com.linlif.leecode;

import java.util.HashMap;

public class num1 {

    public static void main(String[] args) {


    }

    private static int[] gethe(int[] input, int target) {

        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {

            if (indexMap.containsKey(target - input[i])) {

                return new int[]{indexMap.get(target - input[i]), i};
            }

            indexMap.put(input[i], i);
        }

        return new int[]{};
    }
}
