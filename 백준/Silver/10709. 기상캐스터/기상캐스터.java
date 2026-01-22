import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                if (split[j].equals("c")) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = -1;
                }
            }
        }
        int count = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                int before = arr[i][j - 1];
                if (before != -1 && before != 0 && arr[i][j] != 0) {
                    arr[i][j] = count;
                    count++;
                }
                if (before == 0 && arr[i][j] != 0) {
                    count = 1;
                    arr[i][j] = count;
                    count++;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
