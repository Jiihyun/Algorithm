import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp = new long[101];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 3] + dp[j - 2];
            }
            System.out.println(dp[n]);
        }
    }
}
