import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {2, 2, 1, 1, -2, -2, -1, -1};
    static int[] dx = {1, -1, 2, -2, 1, -1, 2, -2};
    static int boardSize;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            boardSize = Integer.parseInt(br.readLine());
            visited = new boolean[boardSize][boardSize];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            System.out.println(bfs(start, end));
        }
    }

    private static int bfs(int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                if (now[0] == end[0] && now[1] == end[1]) {
                    return count;
                }

                for (int j = 0; j < 8; j++) {
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];

                    if (ny >= 0 && ny < boardSize && nx >= 0 && nx < boardSize 
                            && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            count++; 
        }
        return -1;
    }
}
