package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

public class code216 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        findValue(1, k, n, 0, new ArrayList<>());
        return result;
    }


    private void findValue(int index, int k, int n, int sum, List<Integer> temp) {
        if (temp.size() == k || sum >= n) {
            if (temp.size() == k && sum == n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            temp.add(i);
            sum += i;
            findValue(index + 1, k, n, sum, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum32(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<Integer> list, int k, int start, int n) {
        //终止条件，如果满足这个条件，再往下找也没什么意义了
        if (list.size() == k || n <= 0) {
            //如果找到一组合适的就把他加入到集合list中
            if (list.size() == k && n == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(list, k, i + 1, n - i);
            //撤销选择
            list.remove(list.size() - 1);
        }
    }
}
