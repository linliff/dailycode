package com.linlif.leecode;

import java.util.ArrayList;
import java.util.List;

public class code784 {

    public List<String> letterCasePermutation(String s) {
        char[] cs = s.toCharArray();
        List<String> ans = new ArrayList<>();
        bt(cs, ans, 0);
        return ans;
    }

    private void bt(char[] cs, List<String> ans, int index) {
        ans.add(new String(cs));
        for (int i = index; i < cs.length; i++) {
            if (cs[i] >= 'A') {
                cs[i] ^= 32;
                bt(cs, ans, i + 1);
                cs[i] ^= 32;
            }
        }
    }
}
