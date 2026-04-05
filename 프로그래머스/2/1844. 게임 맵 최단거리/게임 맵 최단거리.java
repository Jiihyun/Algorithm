import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int x = maps.length;
        int y = maps[0].length;
        boolean[][] visited = new boolean[x][y];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int distance = cur[2];
            
            if (cx == x - 1 && cy == y - 1) {
                return distance;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < x && ny >= 0 && ny < y
                   && !visited[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny, distance+1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}