import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        while (left <= right) {
            int num = getDivisors(left);
            if (num % 2 == 0) {
                answer += left;
            } else {
                answer -= left;
            }
            left++;
        }
        return answer;
    }
    
    public int getDivisors(int num) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if (i * i != num) {
                    divisors.add (num / i);
                }
            }
        }
        return divisors.size();
    }
}

// 1. 