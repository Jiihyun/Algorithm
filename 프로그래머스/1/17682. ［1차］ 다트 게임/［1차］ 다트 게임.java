import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        char[] arr = dartResult.toCharArray();
        int num = 0;
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (0 <= arr[i] - '0' && arr[i] - '0' <= 9) {
                if (arr[i] == '1' && i + 1 < arr.length && arr[i+1] == '0') {
                    num = 10;
                    i++; 
                } else {
                    num = arr[i] - '0';
                }
            }
            else if (arr[i] == 'S') {
                scores[idx++] = (int)Math.pow(num, 1);
            } else if (arr[i] == 'D') {
                scores[idx++] = (int)Math.pow(num, 2);
            } else if (arr[i] == 'T') {
                scores[idx++] = (int)Math.pow(num, 3);
            }
            else if (arr[i] == '*') {
                scores[idx-1] *= 2;
                if (idx - 2 >= 0) scores[idx-2] *= 2;
            } else if (arr[i] == '#') {
                scores[idx-1] *= -1;
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}
