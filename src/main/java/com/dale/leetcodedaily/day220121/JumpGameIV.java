package com.dale.leetcodedaily.day220121;

import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            g.putIfAbsent(arr[i], new ArrayList<>());
            g.get(arr[i]).add(i);
        }
        Set<Integer> vis = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis.add(0);
        while (!q.isEmpty()) {
            int[] top = q.poll();
            if (top[0] == arr.length - 1)
                return top[1];
            int val = arr[top[0]];
            if (g.containsKey(val)) {
                for (Integer i : g.get(val))
                    if (vis.add(i))
                        q.add(new int[]{i, top[1] + 1});
                g.remove(val);
            }
            if (top[0] + 1 < arr.length && vis.add(top[0] + 1))
                q.add(new int[]{top[0] + 1, top[1] + 1});
            if (top[0] - 1 >= 0 && vis.add(top[0] - 1))
                q.add(new int[]{top[0] - 1, top[1] + 1});
        }
        return -1;
    }
}

public class JumpGameIV {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        Solution s = new Solution();
        System.out.println(s.minJumps(arr));
    }
}
