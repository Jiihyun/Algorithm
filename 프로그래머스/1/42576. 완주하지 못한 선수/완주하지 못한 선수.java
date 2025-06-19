import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> part = new HashMap<>();
        for (String st: participant) {
            part.put(st, part.getOrDefault(st, 0) + 1);
        }
        for (String c: completion) {
            part.put(c, part.get(c) - 1);
        }
        for (Map.Entry<String, Integer> entry : part.entrySet()) {
            if(entry.getValue() == 1 ) {
                answer =  entry.getKey();
            }
        }
        return answer;
}
}