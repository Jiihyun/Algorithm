import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            while (!deque.isEmpty() && deque.peek()[0] <= arr[i]) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(deque.peek()[1]).append(" ");
            }
            deque.push(new int[]{arr[i], i});
        }
        System.out.println(sb);
    }
}
