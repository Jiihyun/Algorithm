import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            Stack<Character> st = new Stack<>();
            boolean isAnswer = true;
            for (Character ch : rotated.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    st.push(ch);
                } else {
                    if (!st.isEmpty()) {
                        Character c = st.peek();
                        if (ch == ')' && c == '('
                           || ch == ']' && c == '['
                           || ch == '}' && c == '{') {
                            st.pop();
                        }
                    } else {
                        isAnswer = false;
                    }
                }
            }
            if (st.isEmpty() && isAnswer) {
                answer++;
            }
        }
        return answer;
    }
}