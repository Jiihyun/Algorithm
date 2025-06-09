import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[][] board;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[] color = {'G', 'B', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        board = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        int count1 = 0;
        for (int i = 0; i < 3; i++) {
            char col = color[i];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (board[y][x] == col && !visited[y][x]) {
                        bfs(y, x, col);
                        count1++;
                    }
                }
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    board[i][j] = 'G';
                }
            }
        }
        int count2 = 0;
        for (int i = 0; i < 2; i++) {
            char col = color[i];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (board[y][x] == col && !visited[y][x]) {
                        bfs(y, x, col);
                        count2++;
                    }
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }

    private static void bfs(int y, int x, char col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n
                        && board[ny][nx] == col && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}
