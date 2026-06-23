import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxGaro = 0;
        int maxSero = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.sort(sizes[i]);
            }
        }
        
        for (int i = 0; i < sizes.length; i++) {
            maxGaro = Math.max(sizes[i][1], maxGaro);
            maxSero = Math.max(sizes[i][0], maxSero);
        }
        return maxSero * maxGaro;
    }
}