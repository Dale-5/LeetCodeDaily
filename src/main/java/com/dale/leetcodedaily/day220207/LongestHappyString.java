package com.dale.leetcodedaily.day220207;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> q = new PriorityQueue<>((x,y)->y[1]-x[1]);
        if (a > 0)
            q.add(new int[]{0, a});
        if (b > 0)
            q.add(new int[]{1, b});
        if (c > 0)
            q.add(new int[]{2, c});
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == top[0] + 'a' && sb.charAt(n - 2) == top[0] + 'a') {
                if (q.isEmpty())
                    break;
                int[] snd = q.poll();
                sb.append((char)(snd[0] + 'a'));
                if (--snd[1] > 0)
                    q.add(snd);
                q.add(top);
            } else {
                sb.append((char)(top[0] + 'a'));
                if (--top[1] > 0)
                    q.add(top);
            }
        }
        return sb.toString();
    }
}

public class LongestHappyString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestDiverseString(1, 1, 7));
    }
}
