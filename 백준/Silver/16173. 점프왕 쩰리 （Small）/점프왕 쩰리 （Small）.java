import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int size;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static String answer = "Hing";
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        board = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int y, int x) {
        if (found) {
            return;
        }
        visited[y][x] = true;
        if (board[y][x] == -1) {
            answer = "HaruHaru";
            found = true;
            return;
        }
        int movement = board[y][x];
        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i] * movement;
            int nx = x + dx[i] * movement;
            if (ny >= 0 && ny < size && nx >= 0 && nx < size) {
                if (!visited[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
