import java.util.*;

class Solution {
    static final int[] dy = {1,-1,0,0};
    static final int[] dx = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            
            if (x == n-1 && y == m-1) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m 
                   && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count+1});
                }
            }
        }
        return -1;
    }
}