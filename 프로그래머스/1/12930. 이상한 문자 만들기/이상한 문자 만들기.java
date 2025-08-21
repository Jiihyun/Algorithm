import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ", -1);
        
        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            
            for (int j = 0; j < arr.length; j++) {
                if (j % 2 == 0) {
                    sb.append(Character.toUpperCase(arr[j]));
                } else {
                    sb.append(Character.toLowerCase(arr[j]));
                }
            }
            if (i < words.length -1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}