import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] reverseDp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            reverseDp[i] = 1;
        }

        // 왼쪽 증가 부분 LIS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 오른쪽 감소 부분 LIS
        for (int i = n; i >= 1; i--) {
            for (int j = i+1; j <= n; j++) {
                if (arr[j] < arr[i]) {
                    reverseDp[i] = Math.max(reverseDp[i], reverseDp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i] + reverseDp[i] - 1);
        }

        System.out.println(max);
    }
}
