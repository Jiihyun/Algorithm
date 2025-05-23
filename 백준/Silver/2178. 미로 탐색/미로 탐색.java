import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] data;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        doBfs(0, 0);
        System.out.println(data[N - 1][M - 1]);
    }

    private static void doBfs(final int i, final int j) {
        Queue<int[]> queue = new LinkedList<>(); 
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) { 
                    if (data[x][y] == 1 && !visited[x][y]) { 
                        visited[x][y] = true;
                        data[x][y] = data[now[0]][now[1]] + 1; 
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
