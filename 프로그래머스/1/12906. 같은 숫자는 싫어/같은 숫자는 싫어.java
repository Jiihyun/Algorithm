import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        int idx = 0;
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
            idx++;
        }
        return answer;
    }
}