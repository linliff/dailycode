package com.linlif.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code40 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrack(path, candidates, target, 0, 0);
        return res;
    }

    private void backtrack(List<Integer> path, int[] candidates, int target, int sum, int begin) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            int rs = candidates[i] + sum;
            if (rs <= target) {
                path.add(candidates[i]);
                backtrack(path, candidates, target, rs, i + 1);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

}
