import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n, h;
    static Queue<int[]> q = new LinkedList<>();
    static int[][][] box;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < m; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());
                    if (box[z][x][y] == 1) {
                        q.add(new int[]{z, x, y});
                    }
                }
            }
        }

        bfs();

        int answer = 0;

        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (box[z][x][y] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, box[z][x][y]);
                }
            }
        }

        System.out.println(answer - 1);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();

            int z = now[0];
            int x = now[1];
            int y = now[2];

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nz >= 0 && nx >= 0 && ny >= 0
                        && nz < h && nx < n && ny < m
                        && box[nz][nx][ny] == 0) {

                    box[nz][nx][ny] = box[z][x][y] + 1;
                    q.add(new int[]{nz, nx, ny});
                }
            }
        }
    }
}