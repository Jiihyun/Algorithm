import java.util.*;

class Solution {
    public int solution(int[] ingredient) { 
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for (int i :ingredient) {
            stack.push(i);
            
            int size = stack.size();
            if (size >= 4) {
                if (stack.get(size-4) ==1 &&
                   stack.get(size-3) == 2 &&
                   stack.get(size-2) == 3 &&
                   stack.get(size-1) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    count++;
                }
            }
        }
        return count;
    }
}