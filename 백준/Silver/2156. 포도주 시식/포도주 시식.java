import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        }
        dp[2] = arr[1] + arr[2];
        if (n == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            int a = dp[i - 1]; // i번째 잔을 마시지 않는다
            int b = dp[i - 2] + arr[i]; // i-1번째 잔을 마시지 않는다
            int c = dp[i - 3] + arr[i - 1] + arr[i]; // i-2번째 잔을 마시지 않는다
            int max1 = Math.max(a, b);
            int max = Math.max(max1, c);
            dp[i] = max;
        }

        System.out.println(dp[n]);
    }
}
