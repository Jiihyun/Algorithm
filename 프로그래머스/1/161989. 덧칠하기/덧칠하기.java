import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) { 
        int answer = 0;
        int paintedUntil = 0; 

        for (int pos : section) {
            if (pos > paintedUntil) {  
                answer++;
                paintedUntil = pos + m - 1;
            }
        }

        return answer;
    }
}