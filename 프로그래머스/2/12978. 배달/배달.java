import java.util.*;

class Solution {

    static class Node {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        pq.offer(new Node(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (now.cost > distance[now.to]) {
                continue;
            }

            for (Node next : graph.get(now.to)) {

                int nextCost = now.cost + next.cost;

                if (nextCost < distance[next.to]) {
                    distance[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}