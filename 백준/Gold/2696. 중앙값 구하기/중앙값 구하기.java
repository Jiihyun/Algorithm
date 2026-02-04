import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());

            Queue<Integer> maxs = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> mins = new PriorityQueue<>();

            StringBuilder sb = new StringBuilder();
            int count = 0;
            int readCount = 0;

            while (readCount < m) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken());
                    readCount++;

                    if (maxs.size() == mins.size()) {
                        maxs.offer(x);
                    } else {
                        mins.offer(x);
                    }

                    if (!mins.isEmpty() && maxs.peek() > mins.peek()) {
                        int a = maxs.poll();
                        int b = mins.poll();
                        maxs.offer(b);
                        mins.offer(a);
                    }

                    if ((maxs.size() + mins.size()) % 2 == 1) {
                        sb.append(maxs.peek()).append(" ");
                        count++;

                        if (count % 10 == 0) {
                            sb.append("\n");
                        }
                    }

                    if (readCount == m) {
                        break;
                    }
                }
            }

            System.out.println(count);
            System.out.println(sb);
        }
    }
}
