import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        arr = new boolean[w][h];

        for (int i = 0; i < w; i++) {
            String line = br.readLine();
            for (int j = 0; j < h; j++) {
                if (line.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int w_row = w - 7;
        int h_row = h - 7;

        for (int i = 0; i < w_row; i++) {
            for (int j = 0; j < h_row; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    private static void find(final int x, final int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {

                if (arr[i][j] != TF) {
                    count++;
                }
                TF = (!TF);
            }
            TF = !TF;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
