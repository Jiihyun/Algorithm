import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String strN = String.valueOf(n);
        
        for (String i : strN.split("")) {
            answer += Integer.parseInt(i);
        }

        return answer;
    }
}