import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, result;
    static int k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            result = new int[6];

            if (k == 0) { // 입력 마지막 값
                break;
            }
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            back(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void back(int depth, int next) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = next; i < k; i++) {
            result[depth] = arr[i];
            back(depth + 1, i + 1);
        }
    }
}

