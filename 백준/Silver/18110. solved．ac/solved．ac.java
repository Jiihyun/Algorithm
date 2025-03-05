import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            q.add(arr[i]);
        }
        long minus = Math.round(N * 0.15);
        for (int i = 0; i < minus; i++) {
            q.pollFirst();
            q.pollLast();
        }
        int size = q.size();
        double sum = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
        }
        System.out.println(Math.round(sum / size));
    }
}
