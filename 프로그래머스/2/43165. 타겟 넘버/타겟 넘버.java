import java.util.*;

class Solution {
    static int answer;
    static int[] numberss;

    public int solution(int[] numbers, int target) {
        answer = 0;
        numberss = numbers;
        int sum = 0;
        
        dfs(1, sum + numbers[0], target);
        dfs(1, sum - numbers[0], target);
        
        return answer;
    }
    
    private void dfs(int index, int sum, int target) {
        if (index == numberss.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
            dfs(index + 1, sum + numberss[index], target);
            dfs(index + 1, sum - numberss[index], target);
    }
}