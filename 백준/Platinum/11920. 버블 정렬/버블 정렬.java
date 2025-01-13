import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int index = 0;

        for (int i = 0; i <= K && i < N; i++) {
            pq.offer(arr[i]);
        }
        for (int i = K + 1; i < N; i++) {
            arr[index++] = pq.poll();
            pq.offer(arr[i]);
        }
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}
