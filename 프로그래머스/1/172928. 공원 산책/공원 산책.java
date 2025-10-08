import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int rows = park.length;
        int cols = park[0].length();
        char[][] grid = new char[rows][cols];

        int sx = -1, sy = -1;
        for (int i = 0; i < rows; i++) {
            String row = park[i];
            for (int j = 0; j < cols; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'S') {
                    sx = i; sy = j;
                }
            }
        }

        Map<String, int[]> dir = new HashMap<>();
        dir.put("N", new int[]{-1, 0});
        dir.put("S", new int[]{1, 0});
        dir.put("W", new int[]{0, -1});
        dir.put("E", new int[]{0, 1});

        int x = sx, y = sy;
        for (String route : routes) {
            String[] parts = route.split(" ");
            String d = parts[0];
            int step = Integer.parseInt(parts[1]);
            int dx = dir.get(d)[0];
            int dy = dir.get(d)[1];

            int nx = x, ny = y;
            boolean ok = true;
            for (int k = 0; k < step; k++) {
                nx += dx;
                ny += dy;
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    ok = false;
                    break;
                }
                if (grid[nx][ny] == 'X') {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                x = nx;
                y = ny;
            }
        }
        return new int[]{x, y};
    }
}
