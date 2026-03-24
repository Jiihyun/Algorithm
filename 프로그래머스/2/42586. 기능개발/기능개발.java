import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                days++;
            }
            stack.add(days);
        }

        List<Integer> result = new ArrayList<>();
        int current = stack.poll();
        int count = 1;
        while (!stack.isEmpty()) {
            int next = stack.poll();
            if (next <= current) {
                count++;
            } else {
                result.add(count);
                current = next;
                count = 1;
            }
        }
        result.add(count);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}