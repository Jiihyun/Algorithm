import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c;
    static boolean[][] visited;
    static boolean[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[a + 1][b + 1];
        answer = new boolean[c + 1];

        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= c; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowA = now[0];
            int nowB = now[1];
            int nowC = c - nowA - nowB;

            if (nowA == 0) {
                answer[nowC] = true;
            }
            move(nowA, nowB, nowC, a, b, c, 0, 1, q);
            move(nowA, nowB, nowC, a, b, c, 0, 2, q);
            move(nowA, nowB, nowC, a, b, c, 1, 0, q);
            move(nowA, nowB, nowC, a, b, c, 1, 2, q);
            move(nowA, nowB, nowC, a, b, c, 2, 0, q);
            move(nowA, nowB, nowC, a, b, c, 2, 1, q);
        }
    }

    private static void move(int nowA, int nowB, int nowC,
                             int a, int b, int c,
                             int from, int to,
                             Queue<int[]> q) {
        int[] water = {nowA, nowB, nowC};
        int[] abc = {a, b, c};

        int movement = Math.min(water[from], abc[to] - water[to]);
        water[from] -= movement;
        water[to] += movement;

        int na = water[0];
        int nb = water[1];

        if (!visited[na][nb]) {
            visited[na][nb] = true;
            q.offer(new int[]{na, nb});
        }
    }
}
