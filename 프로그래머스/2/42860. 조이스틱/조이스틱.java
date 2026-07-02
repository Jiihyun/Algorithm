import java.util.*;

class Solution {

    public int solution(String name) {

        int answer = 0;
        int n = name.length();

        // 상하 이동
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 좌우 이동
        int move = n - 1;

        for (int i = 0; i < n; i++) {

            int next = i + 1;

            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move,
                    Math.min(
                            i * 2 + (n - next),
                            i + 2 * (n - next)
                    ));
        }

        return answer + move;
    }
}