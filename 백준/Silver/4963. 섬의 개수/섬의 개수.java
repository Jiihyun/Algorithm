import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int y, x;
    static int[] dy = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0) {
                return;
            }
            board = new int[y][x];
            visited = new boolean[y][x];

            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int ny, int nx) {
        visited[ny][nx] = true;
        for (int i = 0; i < 8; i++) {
            int cy = ny + dy[i];
            int cx = nx + dx[i];

            if (cy >= 0 && cy < y && cx >= 0 && cx < x) {
                if (board[cy][cx] == 1 && !visited[cy][cx]) {
                    dfs(cy, cx);
                }
            }
        }
    }
}
