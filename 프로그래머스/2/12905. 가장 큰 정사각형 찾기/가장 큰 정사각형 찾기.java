import java.util.*;

class Solution{
    
    static int[][] dp;
    
    public int solution(int [][]board) {
        dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dp[i][j] = board[i][j];
            }
        }
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
            }
        }
    }   
        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
    return answer * answer;
    }
}