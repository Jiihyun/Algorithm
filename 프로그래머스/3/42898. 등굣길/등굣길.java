import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n+1][m+1];
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            board[y][x] = -1;
        }
        
        board[1][1] = 1;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (board[y][x] == -1) {
                    board[y][x] = 0;
                    continue;
                }
                if (y == 1 && x == 1) {
                    continue;
                }
                board[y][x] = (board[y-1][x] + board[y][x-1]) % 1000000007;
            }
        }
        return board[n][m];
    }
}