import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = 0;
        int bIndex = 0;
        
        while (aIndex < A.length && bIndex < B.length) {
            if (A[aIndex] >= B[bIndex]) {
                bIndex++;
            } else {
                aIndex++;
                bIndex++;
                answer++;
            }
        }
        return answer;
    }
}

// 숫자가 큰 쪽이 승리하게 되고, 승리한 사원이 속한 팀은 승점을 1점 얻게 됨