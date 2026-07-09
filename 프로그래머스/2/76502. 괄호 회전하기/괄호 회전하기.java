import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0 ;
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, s.length()) + s.substring(0, i);
            if (isRight(str)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isRight(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.add(ch);
            } else {
                if (!st.isEmpty()) {
                    if ((ch == ')' && st.peek() == '(')
                       || (ch == ']' && st.peek() == '[')
                       || (ch == '}' && st.peek() == '{')) {
                        st.pop();
                    }
                } else {
                    return false;
                }
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}