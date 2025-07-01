import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < size; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        // 크기가 1인 경우 비교가 필요 없음
        if (size == 1) {
            System.out.println(0);
            return;
        }
        
        int sum = 0;

        // 우선순위 큐를 사용하여 최소 비교 횟수 계산
        while (pq.size() > 1) {
            int current = pq.poll() + pq.poll();
            sum += current;
            pq.add(current);
        }
        
        System.out.println(sum);
    }
}
