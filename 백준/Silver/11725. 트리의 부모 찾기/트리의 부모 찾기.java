import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] parent;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        visited = new boolean[size + 1];
        parent = new int[size + 1];
        graph = new List[size + 1];
        for (int i = 1; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < size - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        dfs(1);
        for (int i = 2; i <= size; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int node : graph[i]) {
            if (!visited[node]) {
                parent[node] = i;
                dfs(node);
            }
        }
    }
}
