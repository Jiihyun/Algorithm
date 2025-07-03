import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] box;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        boolean riped = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                box[i][j] = num;
                if (num == 1) {
                    q.add(new int[]{i, j});
                }
                if (num == 0) {
                    riped = false;
                }
            }
        }
        if (riped) {
            System.out.println(0);
        } else {
            int result = bfs();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static int bfs() {
        int count = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;

                if (ny >= 0 && ny < n && nx >= 0 && nx < m
                        && box[ny][nx] == 0) {
                    box[ny][nx] = box[y][x] + 1;
                    q.add(new int[]{ny, nx});
                    count = Math.max(count, box[ny][nx]);
                }
            }
        }
        return count - 1;
    }
}

