import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int spot = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int value = 1;
        int movement = 1;
        int x = n / 2;
        int y = n / 2;

        while (true) {
            for (int i = 0; i < movement; i++) {
                map[y--][x] = value++;
            }
            if (value == n * n + 1) {
                break;
            }
            for (int i = 0; i < movement; i++) {
                map[y][x++] = value++;
            }
            movement++;
            for (int i = 0; i < movement; i++) {
                map[y++][x] = value++;
            }
            for (int i = 0; i < movement; i++) {
                map[y][x--] = value++;
            }
            movement++;
        }

        StringBuilder sb = new StringBuilder();
        int spotA = 0;
        int spotB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (spot == map[i][j]) {
                    spotA = j + 1;
                    spotB = i + 1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(spotB + " " + spotA);
        System.out.println(sb);
    }
}
