import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : graph[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        count[next]++;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
