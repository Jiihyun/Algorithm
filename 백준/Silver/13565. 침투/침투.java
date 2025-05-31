import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int y, x;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        field = new int[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < x; j++) {
                field[i][j] = Integer.parseInt(split[j]);
            }
        }
        boolean result = false;
        for (int i = 0; i < x; i++) {
            if (field[0][i] == 0 && !visited[0][i]) {
                if (dfs(0, i)) {
                    result = true;
                    break;
                }
            }
        }
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean dfs(int ny, int nx) {
        if (ny == y - 1) {
            return true;
        }
        visited[ny][nx] = true;
        for (int i = 0; i < 4; i++) {
            int cy = ny + dy[i];
            int cx = nx + dx[i];

            if (cy >= 0 && cy < y && cx >= 0 && cx < x) {
                if (field[cy][cx] == 0 && !visited[cy][cx]) {
                    if (dfs(cy, cx)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
