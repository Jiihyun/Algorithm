import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[y + 1];

        Arrays.fill(distance, -1);

        queue.add(x);
        distance[x] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == y) {
                return distance[current];
            }

            int[] nextNumbers = {
                current + n,
                current * 2,
                current * 3
            };

            for (int next : nextNumbers) {
                if (next > y) {
                    continue;
                }

                if (distance[next] != -1) {
                    continue;
                }

                distance[next] = distance[current] + 1;
                queue.add(next);
            }
        }

        return -1;
    }
}