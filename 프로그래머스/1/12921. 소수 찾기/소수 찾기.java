import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = sieve(n);
        for (boolean value : prime) {
            if (value) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}