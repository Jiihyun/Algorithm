import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long end = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > end) {
                end = arr[i];
            }
        }
        end += 1;
        long start = 0;

        while (start < end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if (count < N) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start - 1);
    }
}
