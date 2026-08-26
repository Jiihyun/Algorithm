import java.util.*;

class Solution {
    
    static int goal;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        goal = target;
        
        dfs(numbers, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int index, int sum) {
        if (index == numbers.length) {
            if (sum == goal) {
                answer++;
            }
            return;
        }
        dfs(numbers, index+1, sum+numbers[index]);
        dfs(numbers, index+1, sum-numbers[index]);
    }
}