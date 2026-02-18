import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l, r, c;
    static char[][][] board;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            board = new char[l][r][c];
            visited = new boolean[l][r][c];

            int startZ = 0, startX = 0, startY = 0;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = line.charAt(k);

                        if (board[i][j][k] == 'S') {
                            startZ = i;
                            startX = j;
                            startY = k;
                        }
                    }
                }
                br.readLine();
            }
            int answer = bfs(startZ, startX, startY);
            if (answer == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s).");
            }
        }
    }

    private static int bfs(int startZ, int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startZ, startX, startY, 0});
        visited[startZ][startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int z = now[0];
            int x = now[1];
            int y = now[2];
            int time = now[3];

            if (board[z][x][y] == 'E') {
                return time;
            }
            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nz >= 0 && nz < l && nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!visited[nz][nx][ny] && board[nz][nx][ny] != '#') {
                        visited[nz][nx][ny] = true;
                        q.offer(new int[]{nz, nx, ny, time + 1});
                    }
                }
            }
        }
        return -1;
    }
}
