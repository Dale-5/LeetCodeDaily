package com.dale.leetcodedaily.day211215;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] ans = new int[n];
        int[][] g = new int[n][n];
        int[] in =  new int[n];
        for (int[] r : richer) {
            in[r[1]]++;
            g[r[0]][r[1]] = 1;
        }
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0)
                que.add(i);
        }
        while (!que.isEmpty()) {
            int top = que.poll();
            for (int i = 0; i < n; i++)
                if (g[top][i] == 1) {
                    if (quiet[ans[top]] < quiet[ans[i]])
                        ans[i] = ans[top];
                    if (--in[i] == 0)
                        que.add(i);
                }
        }
        return ans;
    }
}

public class LoudAndRich {
    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        Solution851 solution = new Solution851();
        int[] ans = solution.loudAndRich(richer, quiet);
        for (int x : ans)
            System.out.println(x);
    }
}
