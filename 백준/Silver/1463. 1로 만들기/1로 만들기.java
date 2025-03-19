import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // 최소 연산 횟수를 저장할 DP 배열
        int[] dp = new int[num + 1];
        dp[1] = 0; // 1을 1로 만드는 데 필요한 연산 횟수는 0

        for (int i = 2; i <= num; i++) {
            // 기본적으로 1을 빼는 연산
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어질 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어질 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[num]);
    }
}
