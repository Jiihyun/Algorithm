import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] connect;
    static int[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        connect = new List[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            connect[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            connect[s].add(e);
            connect[e].add(s);
        }
        for (int i = 1; i < N + 1; i++) {
             connect[i].sort(Comparator.reverseOrder());
        }
        dfs(R);
        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void dfs(int r) {
        visited[r] = ++count;
        for (int node : connect[r]) {
            if (visited[node] == 0) {
                dfs(node);
            }
        }
    }
}
