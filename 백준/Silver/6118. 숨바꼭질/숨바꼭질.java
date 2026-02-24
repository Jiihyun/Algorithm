import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        bfs();
    }

    private static void bfs() {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
        int maxDistance = 0;
        for (int i : dist) {
            maxDistance = Math.max(maxDistance, i);
        }
        int minBarn = 20_000;
        int count = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == maxDistance) {
                count++;
                minBarn = Math.min(minBarn, i);
            }
        }
        System.out.println(minBarn + " " + maxDistance + " " + count);
    }
}
