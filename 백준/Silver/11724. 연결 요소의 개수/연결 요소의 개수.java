import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                doDfs(i);
            }
        }
        System.out.println(count);
    }

    private static void doDfs(final int n) {
        if (visited[n]) {
            return;
        }
        visited[n] = true;
        for (int i : A[n]) {
            if (!visited[i]) {
                doDfs(i);
            }
        }
    }
}
