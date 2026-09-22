import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int x = 0; x <= d; x += k) {
            long maxY = (long) Math.sqrt((long) d * d - (long) x * x);
            answer += maxY / k + 1;
        }
        return answer;
    }
    
    // private double calculateLength(int x1, int y1) {
    //     long sum = (long) x1 * x1 + (long) y1 * y1;
    //     return Math.sqrt(sum);
    // }
}