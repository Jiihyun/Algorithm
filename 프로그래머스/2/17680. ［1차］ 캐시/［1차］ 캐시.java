import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) { 
        int answer = 0;
        Deque<String> dq = new ArrayDeque<>();
        if (cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (dq.size() < cacheSize && !dq.contains(city)) {
                dq.add(city);
                answer += 5;
            } else {
                 if (dq.contains(city)) {
                    answer++;
                    dq.remove(city);
                    dq.add(city);
                } else {
                    if (!dq.isEmpty()) dq.removeFirst();
                    dq.add(city);
                    answer += 5;
                }   
            }
        }
        return answer;
    }
}