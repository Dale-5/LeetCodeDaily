package com.dale.leetcodedaily.day211228;

import java.util.*;

class Solution {
    private Set<Long> set = new HashSet<>();
    private final int P = 131, OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String word : words) {
            long hash = 0;
            for (int i = 0; i < word.length(); i++)
                hash = hash * P + word.charAt(i) - 'a' + OFFSET;
            set.add(hash);
        }
        List<String> ans = new ArrayList<>();
        for (String word : words)
            if (check(word))
                ans.add(word);
        return ans;
    }

    private boolean check(String word) {
        int n = word.length();
        int[] f = new int[n + 1];
        Arrays.fill(f, 1, f.length, -1);
        for (int i = 0; i <= n; i++)
            if (f[i] != -1) {
                long num = 0;
                for (int j = i + 1; j <= n; j++) {
                    num = num * P + word.charAt(j - 1) - 'a' + OFFSET;
                    if (set.contains(num))
                        f[j] = Math.max(f[j], f[i] + 1);
                }
                if (f[n] > 1)
                    return true;
            }
        return false;
    }
}

public class ConcatenatedWords {
    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        Solution s = new Solution();
        List<String> ans = s.findAllConcatenatedWordsInADict(words);
        for (String st : ans)
            System.out.println(st);
    }
}
