import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] board;
    static int y, x;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        board = new int[y][x];
        visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0; 
        int maxArea = 0; 

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    count++; 
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    private static int bfs(final int cy, final int cx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cy, cx});
        visited[cy][cx] = true;

        int area = 0;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            area++;
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (ny >= 0 && ny < y && nx >= 0 && nx < x) {
                    if (!visited[ny][nx] && board[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        board[ny][nx] = board[now[0]][now[1]] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return area;
    }
}
