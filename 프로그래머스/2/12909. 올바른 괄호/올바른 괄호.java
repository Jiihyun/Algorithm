import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] charArr = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        if(charArr[0]  == ')') {
            return false;
        }
        try {
            for(int i = 0; i<charArr.length; i++) {
                if (charArr[i] == '('){
                    st.add(1);
                } else {
                    st.pop();
                }
            }
            if (st.size()!= 0){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}