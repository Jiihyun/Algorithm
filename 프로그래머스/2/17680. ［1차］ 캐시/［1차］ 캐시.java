import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int time = 0;
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (q.contains(city)) {
                time += 1;
                q.remove(city);
                q.add(city);
                
            } else {
                time += 5;
                if (cacheSize > 0) {
                    if (q.size() >= cacheSize) {
                        q. poll();
                    }
                    q.add(city);
                } 
            }
        }
        return time;
    }
}