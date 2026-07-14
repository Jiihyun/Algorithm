import java.util.*;

class Solution {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < maps.length
                        && ny >= 0 && ny < maps[0].length
                        && maps[nx][ny] == 1) {

                    maps[nx][ny] = maps[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            return -1;
        }
        return maps[maps.length - 1][maps[0].length - 1];
    }
}