import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        
        int edge = 0;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= edge) {
                answer++;
                edge = targets[i][1];
            }

        }
        return answer;
    }
}
//[1,4]
//[4,5]
//[3,7]

//[5,8]
//[5,12]
//[11,13]
//[10,14]