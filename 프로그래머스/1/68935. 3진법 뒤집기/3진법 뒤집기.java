import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = "";
        while (n > 0) {
            num += n % 3;
            n = n / 3;
        }
        for (int i = 0; i < num.length(); i++) {
            answer += Math.pow(3,num.length() -1 -i) * (num.charAt(i) - '0');
        }
        return answer;
    }
}