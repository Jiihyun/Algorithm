import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        board = new int[n + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            board[s][e] = board[e][s] = 1;

        }
        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 1; i < board.length; i++) {
            if (!visited[i] && board[v][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i = 1; i < board.length; i++) {
                if (!visited[i] && board[now][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
