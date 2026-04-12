import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static boolean[][] visited;
    static char[][] sameColors;
    static char[][] colors;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sameColors = new char[n][n];
        colors = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                colors[i][j] = c;
                if (c == 'G') {
                    c = 'R';
                }
                sameColors[i][j] = c;
            }
        }
        int count = bfs(colors);
        int sameCount = bfs(sameColors);
        System.out.println(count + " " + sameCount);
    }

    private static int bfs(char[][] colors) {
        int count = 0;
        visited = new boolean[n][n];
        Queue<Info> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]) {
                    count++;

                    char base = colors[i][j];
                    q.add(new Info(i, j, base));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Info now = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = now.x + dx[d];
                            int ny = now.y + dy[d];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n
                                    && !visited[nx][ny] && colors[nx][ny] == base) {
                                q.add(new Info(nx, ny, colors[nx][ny]));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static class Info {
        int x;
        int y;
        char color;

        public Info(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

}
