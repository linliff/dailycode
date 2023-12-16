package com.linlif.leecode;

import java.util.List;

public class code139 {

    //139. Word Break
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] booleans = new boolean[s.length() + 1];
        booleans[0] = true;
        for (int i = 1; i <= s.length(); i++) {

            for (String word : wordDict) {
                if (i >= word.length()
                        && s.substring(i - word.length(), i).equals(word)
                        && booleans[i - word.length()]) {
                    booleans[i] = true;
                }
            }
        }
        return booleans[s.length()];
    }
}
