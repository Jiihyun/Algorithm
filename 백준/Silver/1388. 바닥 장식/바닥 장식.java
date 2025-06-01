import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        char now = board[y][x];

        if (now == '-') {
            if (x + 1 < m && board[y][x + 1] == '-' && !visited[y][x + 1]) {
                dfs(y, x + 1);
            }
        }
        if (now == '|') {
            if (y + 1 < n && board[y + 1][x] == '|' && !visited[y + 1][x]) {
                dfs(y + 1, x);
            }
        }
    }
}
