import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> container = new Stack<>();
        Stack<Integer> extraCon = new Stack<>();
        int answer = 0;
        int[] newOrder = order.clone();
        Arrays.sort(newOrder);
        
        for (int i = order.length - 1; i >= 0; i--) {
            container.push(newOrder[i]);
        }
        
        for (int i = 0; i < order.length; i++) {
            
            if (!extraCon.isEmpty() 
                && order[i] == extraCon.peek()) {
                extraCon.pop();
                answer++;
                continue;
            }
            while (!container.isEmpty()
                  && container.peek() != order[i]) {
                extraCon.push(container.pop());
            }
            
            if (!container.isEmpty()
               && container.peek() == order[i]) {
                container.pop();
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}