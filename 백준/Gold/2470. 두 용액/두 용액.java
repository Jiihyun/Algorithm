import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// WIL: 절댓값을 통해 특성값이 0에 가장 가까운 용액을 찾을 수 있음
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        int bestSum = Integer.MAX_VALUE;
        int answerLeft = 0;
        int answerRight = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(bestSum)) {
                answerLeft = arr[left];
                answerRight = arr[right];
                bestSum = sum;
            }
            if (sum > 0) {
                right--;
            }
            if (sum < 0) {
                left++;
            }
            if (sum == 0) {
                break;
            }
        }
        System.out.print(answerLeft + " " + answerRight);
    }
}
