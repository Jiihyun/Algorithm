import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    long sum = product(a, 0, i) +
                            product(a, i + 1, j) +
                            product(a, j + 1, k) +
                            product(a, k + 1, N - 1);

                    if (sum > answer) {
                        answer = sum;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static long product(int[] a, int l, int r) {
        long p = 1;
        for (int i = l; i <= r; i++) {
            p *= a[i];
        }
        return p;
    }
}
