import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public static int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        int startX = 0;
        int startY = 0;
        
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = j;
                    startY = i;
                }
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY, startX, 0));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (board[node.y].charAt(node.x) == 'G') {
                return node.count;
            }

            for (int dir = 0; dir < 4; dir++) {

                int ny = node.y;
                int nx = node.x;

                while (true) {
                    int nextY = ny + dy[dir];
                    int nextX = nx + dx[dir];

                    if (nextY < 0 || nextY >= n
                            || nextX < 0 || nextX >= m
                            || board[nextY].charAt(nextX) == 'D') {
                        break;
                    }

                    ny = nextY;
                    nx = nextX;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new Node(ny, nx, node.count + 1));
                }
            }
        }
        return -1;
    }
    
    static class Node {
        int y;
        int x;
        int count;
        
        Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}