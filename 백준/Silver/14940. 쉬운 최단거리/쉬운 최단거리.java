import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board;
    static int[][] result;
    static int targetY, targetX;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    visited[i][j] = true;
                }
                if (board[i][j] == 2) {
                    targetY = i;
                    targetX = j;
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    result[i][j] = -1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{targetY, targetX});
        visited[targetY][targetX] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;
                if (ny >= 0 && ny < n && nx >= 0 && nx < m
                        && !visited[ny][nx] && board[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    result[ny][nx] = result[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}

