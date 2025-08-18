import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        
        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.size() >= 2 && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
        }

        if (pq.peek() < K) {
            return -1;
        }
        return scoville.length - pq.size();
    }
}