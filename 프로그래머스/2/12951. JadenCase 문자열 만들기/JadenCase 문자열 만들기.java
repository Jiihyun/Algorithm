import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ", -1);

        for (String word: arr) {
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (i == 0 && !Character.isDigit(ch)) {
                    sb.append(Character.toUpperCase(ch));
                } 
                else {
                    sb.append(Character.toLowerCase(ch));
                }
            }
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() -1);
    }
}