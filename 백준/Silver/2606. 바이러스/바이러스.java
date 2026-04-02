import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[computer + 1];
        System.out.println(dfs(1) - 1);
    }

    private static int dfs(int i) {
        int count = 1;
        visited[i] = true;

        for (int next : graph.get(i)) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        return count;
    }
}
