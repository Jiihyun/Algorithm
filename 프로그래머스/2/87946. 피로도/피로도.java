    import java.util.*;

    class Solution {
        static boolean[] visited;
        static int answer;

        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];
            answer = 0;
            
            dfs(k, dungeons, answer);
            return answer;
        }

        private void dfs(int k, int[][] dungeons, int count) {
            answer = Math.max(answer, count);
            
            for (int i = 0; i < dungeons.length; i++) {
                if (visited[i]) { 
                    continue;
                }
                if (k >= dungeons[i][0]) { 
                    visited[i] = true;
                    dfs(k - dungeons[i][1], dungeons, count+1);
                    visited[i] = false;
                }
            }
        }
    }   