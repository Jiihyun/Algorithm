import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            Queue<Integer> minQ = new PriorityQueue<>();
            Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> count = new HashMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    minQ.offer(num);
                    maxQ.offer(num);
                    count.put(num, count.getOrDefault(num, 0) + 1);
                } else {
                    String num = st.nextToken();
                    if (num.equals("-1")) {
                        poll(minQ, count);
                        if (!minQ.isEmpty()) {
                            Integer polledNum = minQ.poll();
                            count.put(polledNum, count.getOrDefault(polledNum, 0) - 1);
                        }
                    }
                    if (num.equals("1")) {
                        poll(maxQ, count);
                        if (!maxQ.isEmpty()) {
                            Integer polledNum = maxQ.poll();
                            count.put(polledNum, count.getOrDefault(polledNum, 0) - 1);
                        }
                    }
                }
            }
            poll(minQ,count);
            poll(maxQ,count);
            if (minQ.isEmpty() || maxQ.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxQ.peek() + " " + minQ.remove());
            }
        }
    }

    private static void poll(Queue<Integer> pq, Map<Integer, Integer> count) {
        while (!pq.isEmpty()) {
            int peeked = pq.peek();
            if (count.getOrDefault(peeked, 0) > 0) {
                break;
            }
            pq.poll();
        }
    }
}
