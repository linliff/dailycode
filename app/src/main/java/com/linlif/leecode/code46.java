package com.linlif.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = getList(nums, nums[i]);
            result.add(list);
        }

        return result;

    }

    private List<Integer> getList(int[] nums, int index) {
        List<Integer> result = new ArrayList<>();
        result.add(index);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != index) {
                result.add(nums[i]);
            } else {
                getList(result, nums, index, nums[i]);
            }
        }

        return result;
    }

    private void getList(List<Integer> result, int[] nums, int index1, int index2) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != index1 && nums[i] != index2) {
                result.add(nums[i]);
            }
        }

    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        dfs(res, nums, list);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.addLast(nums[i]);
            dfs(res, nums, list);
            list.removeLast();
        }
    }
}
