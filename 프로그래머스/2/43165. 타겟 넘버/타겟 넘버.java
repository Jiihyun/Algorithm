import java.util.*;

class Solution {
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        return dfs(0, 0);
    }
    
    private int dfs(int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        int plus = dfs(idx+1, sum+numbers[idx]);
        int minus = dfs(idx+1, sum-numbers[idx]);
        return plus + minus;
    }
}