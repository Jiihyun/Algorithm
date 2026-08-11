import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
            
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int[] arr = new int[end - start + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = array[start];
                start++;
            }
            Arrays.sort(arr);
            int idx = commands[i][2] - 1;
            answer[i] = arr[idx];
        }
        return answer;
    }
}

