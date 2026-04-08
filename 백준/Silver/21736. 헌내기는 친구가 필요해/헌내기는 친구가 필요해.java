import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        if (board[x][y] == 'P') {
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && !visited[nx][ny] && board[nx][ny] != 'X') {
                dfs(nx, ny);
            }
        }
    }
}
