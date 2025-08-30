import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) { 
        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        
        int box = score.length / m;
        int answer = 0;

        for (int i = 0; i < box; i++) {
            int minScore = arr[i * m + (m - 1)];
            answer += (minScore * m);
        }
        return answer;
    }
}
