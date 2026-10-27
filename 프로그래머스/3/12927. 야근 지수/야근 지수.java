import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        while (n > 0) {
            n--;
            pq.add(pq.poll() - 1);
        }
        while (!pq.isEmpty() && pq.peek() > 0) {
            int value = pq.poll();
            answer += value * value;
        }
        return answer;
    }
}
