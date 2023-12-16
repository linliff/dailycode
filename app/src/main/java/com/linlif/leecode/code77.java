package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

public class code77 {

    static List<List<Integer>> listTotal = new ArrayList<>();

    public static void main(String args[]) {

        combine(4, 2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, new ArrayList<Integer>(), 1);
        return listTotal;
    }


    public static void backtrack(int n, int k, List<Integer> list, int index) {
        if (list.size() == k) {
            listTotal.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            // 经典回溯模板
            list.add(i);
            // 以 i + 1进行递归
            backtrack(n, k, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
