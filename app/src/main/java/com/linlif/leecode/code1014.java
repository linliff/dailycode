package com.linlif.leecode;

// 1014. 最佳观光组合
public class code1014 {

    public int maxScoreSightseeingPair(int[] values) {
        if (values == null || values.length == 0) {
            return 0;
        }

        int max = values[0] + 0;
        int result = 0;

        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }

        return result;
    }

}
