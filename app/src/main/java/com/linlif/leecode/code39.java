//package com.linlif.leecode;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class code39 {
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        List<List<Integer>> resultList = new ArrayList<>();
//        if (candidates == null || candidates.length == 0) {
//            return resultList;
//        }
//
//        Arrays.sort(candidates);
//
//        for (int i = 0; i < candidates.length; i++) {
//            List<Integer> integers = new ArrayList<>();
//            boolean success = checkSum(integers, candidates, candidates[i], target);
//            if (success) {
//                resultList.add(integers);
//            }
//        }
//        return resultList;
//
//    }
//
//    private boolean checkSum(List<Integer> one, int[] candidates, int temp, int target) {
//        int tempSum = temp;
//        if (tempSum == target) {
//            return true;
//        }
//        boolean success = false;
//        for (int i = 0; i < candidates.length; i++) {
//            tempSum = candidates[i] + tempSum;
//            if (tempSum < target) {
//                one.add(candidates[i]);
//                success = checkSum(one, candidates, tempSum, target);
//            } else if (tempSum == target) {
//                success = true;
//                one.add(candidates[i]);
//            } else if (tempSum > target) {
//                break;
//            }
//        }
//        if (success) {
//            return true;
//        }
//        return false;
//    }
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        // 排序
//        Arrays.sort(candidates); // 从小到大
//        // DFS(回溯 + 剪枝)
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> ans = new ArrayList<>();
//        int sum = 0; // 暂时的和
//
//        dfs(candidates, target, 0, sum, ans, res); // 数组，目标值，起始点, 暂时的和，某答案，结果集
//        return res;
//    }
//
//    public void dfs(int[] candidates, int target, int idx, int sum, List<Integer> ans, List<List<Integer>> res) {
//        if (idx == candidates.length) return; // 从小往大，搜到最大停止
//        sum += candidates[idx]; // 本层计算
//        if (sum > target) { // 以此节点为根的后面的分支全都无效
//            sum -= candidates[idx]; // 恢复现场
//            return; // 此分支结束，不用在往深处搜索
//        } else if (sum < target) {
//            ans.add(candidates[idx]);
//            dfs(candidates, target, idx, sum, ans, res); // 元素可以重复，idx不变
//
//            ans.remove(ans.size() - 1);    // 恢复现场
//            sum -= candidates[idx]; // 恢复现场
//            dfs(candidates, target, idx + 1, sum, ans, res); // idx+1，递归到终点后会停止
//        } else if (sum == target) {
//            ans.add(candidates[idx]);
//            res.add(new ArrayList<>(ans));  // add 至 res;
//
//            ans.remove(ans.size() - 1);    // 恢复现场
//            sum -= candidates[idx]; // 恢复现场
//            return; // 此分支结束，不用在往深处搜索
//        }
//    }
//}
