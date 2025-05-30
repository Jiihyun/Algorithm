import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, n, k;
    static boolean[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < testSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new boolean[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = true;
            }

            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (field[y][x] && !visited[y][x]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (field[ny][nx] && !visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
