package com.dale.leetcodedaily.day211222;

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int ans = 1;
        StringBuilder sb = new StringBuilder(a);
        while (ans <= b.length() / a.length() + 2) {
            if (sb.indexOf(b) != -1)
                return ans;
            sb.append(a);
            ans++;
        }
        return -1;
    }
}

public class RepeatedStringMatch {

    public static void main(String[] args) {
        String a = "abcd", b = "cdabcdab";
        Solution s = new Solution();
        System.out.println(s.repeatedStringMatch(a, b));
    }
}
