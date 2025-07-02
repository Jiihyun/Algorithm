import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int[] nums = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            int mid = deque.size() / 2;
            int targetIndex = deque.indexOf(nums[i]);

            if (targetIndex <= mid) {
                while (deque.getFirst() != nums[i]) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                while (deque.getFirst() != nums[i]) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}

