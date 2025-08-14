import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10]; // 길이가 n이고, 0-9로 시작하는 수들 중 계단 수의 개수

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] % MOD;
            dp[i][9] = dp[i - 1][8] % MOD;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }
        long sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        System.out.println(sum);
    }
}
