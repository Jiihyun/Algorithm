import java.util.*;

class Solution {

    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int cutA = wires[i][0];
            int cutB = wires[i][1];

            int count = bfs(graph, n, cutA, cutB);

            int otherCount = n - count;

            int difference = Math.abs(count - otherCount);

            answer = Math.min(answer, difference);
        }

        return answer;
    }

    private int bfs(
            List<List<Integer>> graph,
            int n,
            int cutA,
            int cutB
    ) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(1);
        visited[1] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if ((current == cutA && next == cutB)
                        || (current == cutB && next == cutA)) {
                    continue;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}