package com.linlif.leecode;

import java.util.List;

public class code120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int length = triangle.size();
        int[] min = new int[length];

        for (int i = length - 1; i > 0; i--) {

            for (int j = 0; j < triangle.get(i).size(); j++) {
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }


        int max = triangle.get(0).get(0);
        int startIndex = 0;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currentList = triangle.get(i);
            if (currentList.get(startIndex) < currentList.get(startIndex + 1)) {
                max += currentList.get(startIndex);
            } else {
                max += currentList.get(startIndex + 1);
                startIndex = startIndex + 1;
            }
        }

        return max;

    }
}
