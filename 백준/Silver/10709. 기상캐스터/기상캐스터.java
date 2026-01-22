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
            String line = br.readLine();
            int lastCloud = -1;
            for (int j = 0; j < w; j++) {
                if (line.charAt(j) == 'c') {
                    arr[i][j] = 0;
                    lastCloud = j;
                } else {
                    if (lastCloud == -1) {
                        arr[i][j] = -1;
                    } else {
                        arr[i][j] = j - lastCloud;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
