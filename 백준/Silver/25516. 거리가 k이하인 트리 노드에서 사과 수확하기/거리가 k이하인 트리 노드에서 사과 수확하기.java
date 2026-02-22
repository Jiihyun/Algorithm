import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static List<Integer>[] graph;
    static int[] apples;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
        }

        apples = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apples[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int result = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int depth = now[1];
            if (depth <= k) {
                result += apples[node];
            }
            if (depth == k) {
                continue;
            }
            for (int next : graph[node]) {
                q.offer(new int[]{next, depth + 1});
            }
        }
        return result;
    }
}
