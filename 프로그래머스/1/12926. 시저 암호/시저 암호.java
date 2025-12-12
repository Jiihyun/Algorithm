import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                answer += ch;
                continue;
            }
            
            int base = Character.isUpperCase(ch) ? 65 : 97;
            int changed = (ch - base + n) % 26;
            answer += (char) (base + changed);
        }
        
        return answer;
    }
}
