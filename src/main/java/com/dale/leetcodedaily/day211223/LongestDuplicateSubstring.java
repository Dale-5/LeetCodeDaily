package com.dale.leetcodedaily.day211223;

import java.util.HashSet;
import java.util.Set;

class Solution {
    long[] h, p;

    void init(String s) {
        int P = 1313131, n = s.length();
        h = new long[n + 5];
        p = new long[n + 5];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + s.charAt(i);
        }
    }

    String check(String s, int len) {
        Set<Long> set = new HashSet<>();
        for (int i = 1; i + len - 1 <= s.length(); i++) {
            long idx = h[i + len - 1] - h[i - 1] * p[len];
            if (set.contains(idx))
                return s.substring(i - 1, i + len - 1);
            set.add(idx);
        }
        return "";
    }

    public String longestDupSubstring(String s) {
        init(s);
        String ans = "";
        int l = 0, r = s.length();
        while (l < r) {
            int mid = l + r + 1 >> 1;
            String t = check(s, mid);
            if (t.length() != 0) {
                l = mid;
                ans = t;
            } else
                r = mid - 1;
        }
        return ans;
    }
}

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        String s = "banana";
        Solution solution = new Solution();
        System.out.println(solution.longestDupSubstring(s));
    }
}
