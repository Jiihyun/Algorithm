class Solution {
    private static boolean[] visit;
    private static int answer;

    public int solution(int k, int[][] dungeons) {
        int depth = 0;
        visit = new boolean[dungeons.length];
        
        dfs(depth, k, dungeons);
        return answer;
    }
    
    private static void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}