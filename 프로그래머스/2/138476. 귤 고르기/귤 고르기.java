import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        int answer = 0;
        while (k > 0) {
            for (int value : counts) {
                if (value >= k) {
                    answer++;
                    return answer;
                } else {
                    answer++;
                    k -= value;
                }
            }
        }
        return answer;
    }
}