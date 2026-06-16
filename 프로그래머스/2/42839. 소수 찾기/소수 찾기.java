import java.util.*;

class Solution {
    
    static boolean[] visited;
    static Set<Integer> nums = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs("", numbers);  
        return nums.size();
    }
    
    private void dfs(String current, String numbers) {
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                nums.add(num);
            }
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(current + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}