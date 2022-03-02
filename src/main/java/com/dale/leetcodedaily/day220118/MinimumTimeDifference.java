package com.dale.leetcodedaily.day220118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++)
            minutes[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        Arrays.sort(minutes);
        int ans = 1500;
        for (int i = 0; i < timePoints.size() - 1; i++)
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        return Math.min(ans, 1440 - minutes[timePoints.size() - 1] + minutes[0]);
    }
}

public class MinimumTimeDifference {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>(Arrays.asList("00:00","23:59","00:00"));
        Solution s = new Solution();
        System.out.println(s.findMinDifference(timePoints));
    }
}
