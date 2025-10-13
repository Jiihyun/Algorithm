import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        
        for (char c : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            if (c == 'U') {
                ny = y + 1;
            } else if (c == 'D') {
                ny = y - 1;
            } else if (c == 'R') {
                nx = x + 1;
            } else if (c == 'L') { 
                nx = x - 1;
            }

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 간선을 무향으로 저장: (x,y):(nx,ny) 를 정규화
            String edge;
            if (x < nx || (x == nx && y < ny)) {
                edge = x + "," + y + ":" + nx + "," + ny;
            } else {
                edge = nx + "," + ny + ":" + x + "," + y;
            }
            set.add(edge);

            x = nx;
            y = ny;
        }
        return set.size();
    }
}
