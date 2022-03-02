package com.dale.leetcodedaily.day211218;

class Solution419 {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.'))
                    ans++;
        return ans;
    }
}

public class BattleshipsInABoard {

    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        Solution419 s = new Solution419();
        System.out.println(s.countBattleships(board));
    }
}
