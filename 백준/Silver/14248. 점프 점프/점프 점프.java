import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());

        System.out.println(bfs(start));
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            int right = now + board[now];
            int left = now - board[now];

            if (right >= 1 && right <= n && !visited[right]) {
                visited[right] = true;
                q.offer(right);
                count++;
            }
            if (left >= 1 && left <= n && !visited[left]) {
                visited[left] = true;
                q.offer(left);
                count++;
            }
        }
        return count;
    }
}
