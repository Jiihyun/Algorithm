import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] lectures = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); 
            lectures[i][1] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(lectures, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lectures[0][1]); // 첫 강의 끝나는 시간

        for (int i = 1; i < n; i++) {
            // 가장 빨리 끝나는 강의보다 다음 강의 시작 시간이 같거나 크면, 강의실 재사용
            if (pq.peek() <= lectures[i][0]) {
                pq.poll(); 
            }
            pq.add(lectures[i][1]);
        }

        System.out.println(pq.size());
    }
}
