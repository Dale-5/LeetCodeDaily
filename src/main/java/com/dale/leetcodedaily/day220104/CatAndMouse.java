package com.dale.leetcodedaily.day220104;

import java.util.Arrays;

class Solution {
    int[][] graph;
    int[][][] dp;
    int n;

    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.dp = new int[n][n][n*2];
        for (int[][] x : dp)
            for (int[] y : x)
                Arrays.fill(y, -1);
        return getResult(1, 2, 0);
    }

    private int getResult(int mouse, int cat, int turn) {
        if (turn == n * 2)
            return 0;
        if (dp[mouse][cat][turn] < 0) {
            if (mouse == 0)
                dp[mouse][cat][turn] = 1;
            else if (cat == mouse)
                dp[mouse][cat][turn] = 2;
            else
                getNext(mouse, cat, turn);
        }
        return dp[mouse][cat][turn];
    }

    private void getNext(int mouse, int cat, int turn) {
        int curMove = turn%2 == 0 ? mouse : cat;
        int defaultResult = curMove == mouse ? 2 : 1;
        int result = defaultResult;
        for (int next : graph[curMove]) {
            if (curMove == cat && next == 0)
                continue;
            int nextMouse = curMove == mouse ? next : mouse;
            int nextCat = curMove == cat ? next : cat;
            int nextResult = getResult(nextMouse, nextCat, turn+1);
            if (nextResult != defaultResult) {
                result = nextResult;
                if (result != 0)
                    break;
            }
        }
        dp[mouse][cat][turn] = result;
    }
}

public class CatAndMouse {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{2,5},{3},{0,4,5},{1,4,5},{2,3},{0,2,3}};
        Solution s = new Solution();
        System.out.println(s.catMouseGame(graph));
    }
}
