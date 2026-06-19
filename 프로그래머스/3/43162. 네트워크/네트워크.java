import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int current, int[][] computers) {
        visited[current] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 & !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}

