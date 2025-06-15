import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalCase; i++) {
            int size = Integer.parseInt(br.readLine());
            graph = new List[size + 1];
            for (int j = 1; j <= size; j++) {
                graph[j] = new ArrayList<>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[j].add(num);
                graph[num].add(j);
            }
            visited = new boolean[size + 1];
            int count = 0;
            for (int j = 1; j <= size; j++) {
                if (!visited[j]) {
                    dfs(j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int j) {
        visited[j] = true;
        for (int node : graph[j]) {
            if (!visited[node]) {
                dfs(node);
            }
        }

    }
}

