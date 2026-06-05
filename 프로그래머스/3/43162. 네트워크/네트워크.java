import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int networkCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                networkCount++;
            }
        }
        return networkCount;
    }
    
    public void dfs(int current, int[][] computers) {
        visited[current] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[current][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}