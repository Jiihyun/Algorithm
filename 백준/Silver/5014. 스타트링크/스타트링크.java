import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f, s, g, u, d;
    static int[] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[f + 1];
        visited = new boolean[f + 1];
        int answer = bfs(s);
        if (answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println("use the stairs");
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[f + 1];

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == g) {
                return distance[now];
            }

            int up = now + u;
            int down = now - d;

            if (up >= 1 && up <= f && !visited[up]) {
                visited[up] = true;
                q.offer(up);
                distance[up] = distance[now] + 1;
            }
            if (down >= 1 && down <= f && !visited[down]) {
                visited[down] = true;
                q.offer(down);
                distance[down] = distance[now] + 1;
            }
        }
        return -1;
    }
}
