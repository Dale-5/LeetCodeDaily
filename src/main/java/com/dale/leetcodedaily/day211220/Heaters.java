package com.dale.leetcodedaily.day211220;

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = -1;
        Arrays.sort(heaters);
        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house), cur = 0;
            if (idx < 0) {
                int pos = -idx - 1;
                cur = Math.min(pos == 0 ? Integer.MAX_VALUE : house - heaters[pos - 1], pos == heaters.length ? Integer.MAX_VALUE : heaters[pos] - house);
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}

public class Heaters {

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        Solution s = new Solution();
        System.out.println(s.findRadius(houses, heaters));
    }
}
