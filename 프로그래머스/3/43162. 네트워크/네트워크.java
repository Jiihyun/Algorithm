class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int i, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers);
            }
        }
    }
}

/*
연결된 덩어리 개수 구하는 문제네.

한 노드에서 연결된 모든 노드를 방문하면 되겠네.

DFS/BFS 둘 다 되는데 DFS가 코드가 좀 간단하겠다.

→ DFS 선택
*/