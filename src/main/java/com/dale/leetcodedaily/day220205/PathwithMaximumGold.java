package com.dale.leetcodedaily.day220205;

class Solution {
    int[][] g, dir = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] vis;
    int m, n;

    public int getMaximumGold(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (g[i][j] != 0) {
                    vis[i][j] = true;
                    ans = Math.max(ans, dfs(i, j));
                    vis[i][j] = false;
                }
        return ans;
    }

    int dfs(int x, int y) {
        int ans = g[x][y];
        for (int[] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] != 0 && !vis[nx][ny]) {
                vis[nx][ny] = true;
                ans = Math.max(ans, g[x][y] + dfs(nx, ny));
                vis[nx][ny] = false;
            }
        }
        return ans;
    }
}

public class PathwithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        Solution s = new Solution();
        System.out.println(s.getMaximumGold(grid));
    }
}
