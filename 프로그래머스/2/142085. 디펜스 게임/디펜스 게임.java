import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        int now = n;
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            now -= enemy[i];
            if (now < 0) {
                if (k == 0) {
                    return i;
                }
                k--;
                int max = pq.poll();
                now += max;
            }
        }
        return enemy.length;
    }
}
