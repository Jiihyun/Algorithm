import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] building = new char[h][w];
            Queue<int[]> fireQueue = new LinkedList<>();
            Queue<int[]> personQueue = new LinkedList<>();
            boolean[][] visited = new boolean[h][w];

            for (int j = 0; j < h; j++) {
                char[] chars = br.readLine().toCharArray();
                for (int k = 0; k < w; k++) {
                    building[j][k] = chars[k];

                    if (chars[k] == '*') {
                        fireQueue.offer(new int[]{j, k});
                    } else if (chars[k] == '@') {
                        personQueue.offer(new int[]{j, k});
                        visited[j][k] = true;
                    }
                }
            }
            int result = bfs(building, fireQueue, personQueue, h, w, visited);
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    private static int bfs(char[][] building, Queue<int[]> fireQueue, Queue<int[]> personQueue, int h, int w, boolean[][] visited) {
        int time = 0;
        while (!personQueue.isEmpty()) {
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {

                int[] now = fireQueue.poll();
                int x = now[0];
                int y = now[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (building[nx][ny] == '.' || building[nx][ny] == '@') {
                            building[nx][ny] = '*';
                            fireQueue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            int personSize = personQueue.size();
            for (int i = 0; i < personSize; i++) {
                int[] cur = personQueue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        return time + 1;
                    }

                    if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                        if (!visited[nx][ny] && building[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            personQueue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
