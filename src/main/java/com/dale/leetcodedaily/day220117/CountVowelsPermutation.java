package com.dale.leetcodedaily.day220117;

import java.util.Arrays;

class Solution {
    int MOD = (int)1e9 + 7;
    public int countVowelPermutation(int n) {
        if (n == 1)
            return 5;
        long[][] dp = new long[n][5];
        Arrays.fill(dp[0], 1);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][3] = dp[i - 1][2] + dp[i - 1][4];
            dp[i][4] = dp[i - 1][0];
            for (int j = 0; j < 5; j++) {
                dp[i][j] %= MOD;
                if (i == n - 1)
                    ans += dp[i][j];
            }
        }
        return (int) (ans % MOD);
    }
}

public class CountVowelsPermutation {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countVowelPermutation(158));
    }
}
