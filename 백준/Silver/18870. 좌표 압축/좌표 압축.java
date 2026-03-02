import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = Arrays.copyOf(arr,n);
        Arrays.sort(sorted);
        int[] unique = Arrays.stream(sorted).distinct().toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int result = lowerBound(unique, arr[i]);
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int i) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < i) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
