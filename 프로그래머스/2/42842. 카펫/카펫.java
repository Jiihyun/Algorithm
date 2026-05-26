import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int ga = 0; 
        int se = 0;
        
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                se = i;
                ga = yellow / i;
            }
            
            int total = (ga + 2) * (se + 2);

            if (total - yellow == brown) {
                 return new int[]{ga + 2, se + 2};
            }
        }
        return new int[]{0, 0};
    }
}

// yellow = 1 -> brown = 8 [3,3]
// yellow = 2 -> brown = 10 [4,3] 짝
// yellow = 3 -> brown = 12 [5,3]
// yellow = 4 -> brown = 12 [4,4] 짝
// yellow = 5 -> brown = 16 [7,3]
// yellow = 6 -> brown = 14 [5,4] 짝
// yellow = 7 -> brown = 20 [9,3]