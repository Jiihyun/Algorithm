import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static String[][] board;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = tokens[j];
            }
        }
        int b = 0;
        int w = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j].equals("W") && !visited[i][j]) {
                    int size = bfs(i, j, "W");
                    w += size * size;
                } else if (board[i][j].equals("B") && !visited[i][j]) {
                    int size = bfs(i, j, "B");
                    b += size * size;
                }
            }
        }
        System.out.println(w + " " + b);
    }


    private static int bfs(int i, int j, String color) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int ny = dy[d] + now[0];
                int nx = dx[d] + now[1];

                if (ny >= 0 && ny < m && nx >= 0 && nx < n
                        && !visited[ny][nx] && board[ny][nx].equals(color)) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
        return count;
    }
}
