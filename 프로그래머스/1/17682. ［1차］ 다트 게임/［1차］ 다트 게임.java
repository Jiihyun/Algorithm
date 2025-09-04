import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int num = 0;
        int idx = 0;
        char[] arr = dartResult.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (Character.isDigit(ch)) {
                if (ch == '1' && i + 1 < arr.length && arr[i+1] == '0') {
                    num = 10;
                    i++;
                } else{
                 num = ch - '0';   
                }
            } else if (ch == 'S' || ch == 'D' || ch == 'T') {
                if (ch == 'S') {
                    scores[idx] = num;
                }
                if (ch == 'D') {
                    scores[idx] = (int) Math.pow(num, 2);
                }
                if (ch == 'T') {
                    scores[idx] = (int) Math.pow(num, 3);
                }
                idx++;
            } else if (ch == '*') {
                if (idx -2 >= 0) {
                    scores[idx - 2] *= 2;
                }
                scores[idx - 1] *= 2;
            } else if (ch == '#') {
                scores[idx - 1] *= -1;
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}
