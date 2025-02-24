import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int nowW = arr[i][0];
            int nowH = arr[i][1];
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nowW < arr[j][0] && nowH < arr[j][1] ) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
