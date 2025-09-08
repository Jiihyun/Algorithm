import java.util.*;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;
        String current = s;
        
        while (!current.equals("1")) {
            StringBuilder sb = new StringBuilder();
            for (char ch :current.toCharArray()) {
                if (ch == '1') {
                    sb.append('1');
                } else {
                    zeroCount++;
                }
            }
            int length = sb.toString().length();
            current = Integer.toBinaryString(length);
            count++;
        }
        int[] answer = {count, zeroCount};
        return answer;
    }
}