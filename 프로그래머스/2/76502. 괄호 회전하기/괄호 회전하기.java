import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String origin = s;
        
        for (int i = 0; i < s.length(); i++) {
            s = origin.substring(i) + origin.substring(0,i);
            
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            
            for (Character ch: s.toCharArray()) {
                if ( ch == '[' || ch == '(' || ch == '{') {
                    stack.push(ch);
                    continue;
                }
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                if (stack.peek() == '(' && ch == ')') { 
                    stack.pop();
                } else if (stack.peek() == '{' && ch == '}') { 
                    stack.pop();
                } else if (stack.peek() == '[' && ch == ']') { 
                    stack.pop();
                } else {
                    isValid = false;
                    break;
                }

            }
            if (isValid && stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}

