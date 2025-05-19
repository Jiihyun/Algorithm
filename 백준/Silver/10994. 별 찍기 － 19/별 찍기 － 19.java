import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num = 4 * n - 3;
        arr = new char[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = ' ';
            }
        }
        reculsive(0, num);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void reculsive(int s, int len) {
        if (len <= s) {
            return;
        }
        for (int i = s; i < len; i++) {
            arr[s][i] = '*';
            arr[len - 1][i] = '*';
            arr[i][s] = '*';
            arr[i][len - 1] = '*';
        }
        reculsive(s + 2, len - 2);
    }
}

