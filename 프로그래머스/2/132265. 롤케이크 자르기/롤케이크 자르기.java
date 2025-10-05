import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> left = new HashMap<>();
        Set<Integer> right = new HashSet<>();
        
        for (int i : topping) {
            left.put(i, left.getOrDefault(i, 0) + 1);
        }
        
        for (int i : topping) {
            right.add(i);
            left.put(i, left.get(i) - 1);
            
            if (left.get(i) == 0) {
                left.remove(i);
            }
            if (left.size() == right.size()) {
                answer++;
            }
        }
        return answer;
    }
}