import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] dp = new int[size + 1];
        int[] score = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        if (size == 1) {
            System.out.println(score[1]);
        } else if (size == 2) {
            System.out.println(score[1] + score[2]);
        } else {
            dp[1] = score[1];
            dp[2] = score[1] + score[2];
            dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

            for (int i = 4; i <= size; i++) {
                int a = dp[i - 2] + score[i];
                int b = dp[i - 3] + score[i] + score[i - 1];
                dp[i] = Math.max(a, b);
            }
            System.out.println(dp[size]);
        }
    }
}

