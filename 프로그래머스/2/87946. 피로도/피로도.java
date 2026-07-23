import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        return dfs(k, dungeons);
    }
    
    private int dfs(int now, int[][]dungeons) {
        int max = 0;
        
        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];
            int used = dungeons[i][1];
            
            if (!visited[i] && now >= need) {
                visited[i] = true;
                max = Math.max(max, dfs(now - used, dungeons) + 1);
                visited[i] = false;
            }
        } 
        return max;
    }
}