import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = (now[0] + dx[i] + n) % n;
                int ny = (now[1] + dy[i] + m) % m;
                if (!visited[nx][ny] && board[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
