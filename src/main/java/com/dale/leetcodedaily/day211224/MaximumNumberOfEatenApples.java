package com.dale.leetcodedaily.day211224;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0, day = 0, n = apples.length;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        while (day < n || !queue.isEmpty()) {
            while (!queue.isEmpty() && queue.element()[0] <= day)
                queue.remove();
            if (day < n && apples[day] != 0)
                queue.add(new int[]{day + days[day], apples[day]});
            if (!queue.isEmpty()) {
                int[] top = queue.remove();
                ans++;
                if (--top[1] > 0)
                    queue.add(top);
            }
            day++;
        }
        return ans;
    }
}

public class MaximumNumberOfEatenApples {
    public static void main(String[] args) {
        int[] apples = {1,2,3,5,2}, days = {3,2,1,4,2};
        Solution s = new Solution();
        System.out.println(s.eatenApples(apples, days));
    }
}
