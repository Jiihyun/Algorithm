import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {    
        String answer = "";
        int left = 10;
        int right = 12;
        
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number == 0) {
                number = 11;
            }
            if (number == 1 || number == 4 || number == 7) {
                left = number;
                answer += "L";
            } else if (number == 3 || number == 6 || number == 9) {
                right = number;
                answer += "R";
            } else {
                int leftDist = getDistance(left, number);
                int rightDist = getDistance(right, number);
                
                if (leftDist < rightDist) {
                    answer += "L";
                    left = number;
                } else if (leftDist > rightDist) {
                    answer += "R";
                    right = number;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right = number;
                    } else {
                        answer += "L";
                        left = number;
                    }
                }
            }
        }
        return answer;
    }
    
    private int getDistance(int from, int to) {
        int[] fromPos = {(from-1) / 3, (from-1) % 3};
        int[] toPos   = {(to-1) / 3,   (to-1) % 3};
        return Math.abs(fromPos[0] - toPos[0]) + Math.abs(fromPos[1] - toPos[1]);
    }
}