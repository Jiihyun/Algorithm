class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int minDistance = Math.abs(x - r) + Math.abs(y - c);
        
        if (minDistance > k || (k - minDistance) % 2 != 0) {
            return "impossible";
        }
        
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] directions = {'d', 'l', 'r', 'u'};
        
        for (int step = 0; step < k; step++) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }
                int remaining = k - step - 1;
                int distance = Math.abs(nx - r) + Math.abs(ny - c);
                if (distance <= remaining && (remaining - distance) % 2 == 0) {
                    answer += directions[i];
                    x = nx;
                    y = ny;
                    break;
                }
            }
        }
        return answer;
    }
}
// (x, y)와 (r, c)격자를 포함해, 같은 격자를 두 번 이상 방문해도 됨
// 사전순 가장 빠른 경로
// 위 조건대로 미로를 탈출할 수 없는 경우 "impossible"을 return 