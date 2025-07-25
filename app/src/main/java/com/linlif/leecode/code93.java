package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

public class code93 {

    class Solution {
        List<String> ans = new ArrayList();
        List<String> t = new ArrayList();
        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, 4);   // 4表示需要有4段
            return ans;
        }

        public void dfs(String s, int i, int k) {
            if (k == 0) {
                if (i == s.length()) ans.add(String.join(".", t));
                return;
            }
            for (int j = i; j < s.length() && j < i + 3; ++j) {
                if (s.charAt(i) == '0' && j > i) return;    // 不能是前导0
                int v = Integer.parseInt(s.substring(i, j + 1));
                if (v >= 0 && v <= 255) {
                    t.add(s.substring(i, j + 1));
                    dfs(s, j + 1, k - 1);
                    t.remove(t.size() - 1);
                }
            }
        }
    }
}
