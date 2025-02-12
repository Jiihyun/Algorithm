import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[][] data;
    static int n, m, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        data = new int[n + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            data[s][e] = data[e][s] = 1;
        }

        visited = new boolean[n + 1];
        doDfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        doBfs(v);
    }

    private static void doDfs(final int v) {
        visited[v] = true;
        System.out.print(v + " ");
        if (v == data.length) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            if (data[v][i] == 1 && !visited[i]) {
                doDfs(i);
            }
        }
    }

    private static void doBfs(final int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 1; i < data.length; i++) {
                if (data[tmp][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
