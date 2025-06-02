import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int size;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static List<Integer> counts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        board = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(token[j]);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    int count = dfs(i, j);
                    counts.add(count);
                }
            }
        }
        Collections.sort(counts);
        System.out.println(counts.size());
        for (int count : counts) {
            System.out.println(count);
        }
    }

    private static int dfs(int y, int x) {
        visited[y][x] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < size && nx >= 0 && nx < size) {
                if (board[ny][nx] == 1 & !visited[ny][nx]) {
                    count += dfs(ny, nx);
                }
            }
        }
        return count;
    }
}
