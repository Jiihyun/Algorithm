import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[size + 1];
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= size; i++) {
            dq.addLast(new int[]{(i), arr[i]});
        }
        for (int i = 1; i < size; i++) {
            int[] num = dq.pollFirst();
            sb.append(num[0]).append(" ");
            int movement = num[1];
            if (movement > 0) {
                for (int j = 1; j <= movement - 1; j++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int j = 0; j >= movement + 1; j--) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }
        int[] num = dq.pollFirst();
        sb.append(num[0]).append(" ");
        System.out.println(sb);
    }
}
