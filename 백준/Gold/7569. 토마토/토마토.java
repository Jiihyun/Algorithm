import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dk = {0, 0, 0, 0, 1, -1};
    static int[][][] box;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        boolean riped = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 0) {
                        riped = false;
                    }
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        if (riped) {
            System.out.println(0);
            return;
        }
        int result = bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs() {
        int count = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int k = now[0];
            int y = now[1];
            int x = now[2];
            for (int i = 0; i < 6; i++) {
                int nk = dk[i] + k;
                int ny = dy[i] + y;
                int nx = dx[i] + x;
                if (nk >= 0 && nk < h && ny >= 0 && ny < n && nx >= 0 && nx < m && box[nk][ny][nx] == 0) {
                    box[nk][ny][nx] = box[k][y][x] + 1;
                    queue.add(new int[]{nk, ny, nx});
                    count = Math.max(count, box[nk][ny][nx]);
                }
            }
        }
        return count - 1;
    }
}

