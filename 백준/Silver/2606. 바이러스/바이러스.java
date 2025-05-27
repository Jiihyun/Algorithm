import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] connect;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int connectCount = Integer.parseInt(br.readLine());
        visited = new boolean[size + 1];
        connect = new ArrayList[size + 1];

        for (int i = 1; i < size + 1; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            connect[s].add(e);
            connect[e].add(s);
        }
        dfs(1);
        System.out.println(count - 1);
    }

    private static void dfs(int node) {
        visited[node] = true;
        count++;
        for (int i : connect[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
