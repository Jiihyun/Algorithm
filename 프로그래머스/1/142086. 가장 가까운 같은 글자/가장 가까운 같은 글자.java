import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] split = s.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(split[i])) {
                int index = map.get(split[i]);
                answer[i] = i - index;
                map.put(split[i], i);
            } else {
                answer[i] = -1;
                map.put(split[i], i);
            }
        }
        return answer;
    }
}