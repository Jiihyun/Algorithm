import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X'
                   && !visited[i][j]) {
                    int sum = dfs(i, j, maps);
                    answer.add(sum);
                }
            }
        }
        int sum = 0;
        int[] ans = new int[answer.size()];
        for (int i = 0 ; i < answer.size(); i++) {
            ans[i] = answer.get(i);
            sum += answer.get(i);
        }
        Arrays.sort(ans);
        if (sum == 0) {
            return new int[]{-1};
        }
        return ans;
    }
    
    private int dfs(int x, int y, String[] maps) {
        visited[x][y] = true;
        
        int sum = maps[x].charAt(y) - '0';
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < maps.length
               && ny >= 0 && ny < maps[0].length()) {
                if (maps[nx].charAt(ny) != 'X'
                   && !visited[nx][ny]) {
                    sum += dfs(nx, ny, maps);
                }
            }
        }
        return sum;
    }
}

//  'X': 바다, 숫자: 무인도 & 식량 -> 최대 며칠동안 머물 수 있는지
// 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return or  -1