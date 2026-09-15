import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < topping.length; i++) {
            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = topping.length - 1; i >= 0; i--) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
            left.put(topping[i], left.get(topping[i]) - 1);
            
            if (left.get(topping[i]) == 0) {
                left.remove(topping[i]);
            }
            
            if (left.keySet().size() == right.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }
}