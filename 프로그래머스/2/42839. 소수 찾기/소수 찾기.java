import java.util.*;

class Solution {
    
    static Set<Integer> set;
    static boolean[] visited;
    static String numbers;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        dfs("");
        
        return set.size();
    }
    
    private void dfs(String current) {
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(current + numbers.charAt(i));
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}