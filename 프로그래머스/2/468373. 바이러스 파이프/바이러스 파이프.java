import java.util.*;

class Solution {

    static boolean[] infected;
    static List<int[]>[] graph;
    static int answer;
    static int nodeCount;
    static int maxActionCount;

    public int solution(int n, int infection, int[][] edges, int k) {
        nodeCount = n;
        maxActionCount = k;
        answer = 0;

        // 노드 연결
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int type = edges[i][2];

            graph[from].add(new int[]{to, type});
            graph[to].add(new int[]{from, type});
        }

        // 처음 감염된 노드 표시
        infected = new boolean[n + 1];
        infected[infection] = true;

        // 최대 k번까지 A/B/C 파이프 여는 모든 경우 탐색
        dfs(0, infected);

        return answer;
    }

    private void dfs(int depth, boolean[] infected) {
        answer = Math.max(answer, countInfected(infected));

        if (depth == maxActionCount) {
            return;
        }

        for (int pipeType = 1; pipeType <= 3; pipeType++) {
            boolean[] nextInfected = spread(infected, pipeType);
            dfs(depth + 1, nextInfected);
        }
    }

    private boolean[] spread(boolean[] infected, int pipeType) {
        boolean[] nextInfected = infected.clone();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= nodeCount; i++) {
            if (nextInfected[i]) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] next : graph[current]) {
                int nextNode = next[0];
                int nextType = next[1];

                if (nextType != pipeType) {
                    continue;
                }

                if (nextInfected[nextNode]) {
                    continue;
                }

                nextInfected[nextNode] = true;
                queue.add(nextNode);
            }
        }

        return nextInfected;
    }

    private int countInfected(boolean[] infected) {
        int count = 0;

        for (int i = 1; i <= nodeCount; i++) {
            if (infected[i]) {
                count++;
            }
        }

        return count;
    }
}