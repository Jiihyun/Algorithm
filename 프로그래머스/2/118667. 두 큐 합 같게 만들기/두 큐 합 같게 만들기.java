import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        long goal = (sum1 + sum2) / 2;
        int count = 0;
        int limit = queue1.length + queue2.length;
        
        while (count < limit * 2) {
            if (sum1 == sum2 && sum1 == goal) {
                return count;
            }
            if (sum1 > goal) {
                int value = q1.poll();
                q2.add(value);
                sum1 -= value;
                sum2 += value;
                count++;
            } else if (sum1 < goal) {
                int value = q2.poll();
                q1.add(value);
                sum2 -= value;
                sum1 += value;
                count++;
            }
        }
        return -1;
    }
}

// 각 큐의 원소 합이 같도록 함, 작업의 최소 횟수 pop+insert

// 큐 2개 원소들 합 /2 한게 각 큐의 원소들 합이어야 함