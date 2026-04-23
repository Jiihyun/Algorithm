import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stair = new int[n];
        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stair[0]);
            return;
        }

        if (n == 2) {
            System.out.println(stair[0] + stair[1]);
            return;
        }

        int[] dp = new int[n];
        dp[0] = stair[0];
        dp[1] = stair[0] + stair[1];
        dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(
                    dp[i - 3] + stair[i - 1] + stair[i],
                    dp[i - 2] + stair[i]
            );
        }

        System.out.println(dp[n - 1]);
    }
}