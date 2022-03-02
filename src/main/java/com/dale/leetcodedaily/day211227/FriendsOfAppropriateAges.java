package com.dale.leetcodedaily.day211227;

import java.util.Arrays;

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int[] cnt = new int[121];
        for (int age : ages)
            cnt[age]++;
        for (int i = 1; i <= 120; i++)
            cnt[i] += cnt[i - 1];
        int ans = 0;
        for (int i = 15; i <= 120; i++)
            ans += (cnt[i] - cnt[i - 1]) * (cnt[i] - cnt[i / 2 + 7] - 1);
        return ans;
    }
}

public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        int[] ages = {16, 17, 18};
        Solution s = new Solution();
        System.out.println(s.numFriendRequests(ages));
    }
}
