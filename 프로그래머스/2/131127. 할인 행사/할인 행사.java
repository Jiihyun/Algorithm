import java.util.*;

class Solution {
    static Map<String, Integer> bucket = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        initMap(want, number);
        
        for (int i = 0; i <= discount.length - 10; i++) {
            boolean pass = false;
            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                if (bucket.containsKey(item) && bucket.get(item) > 0) {
                    bucket.put(item, bucket.get(item) - 1);
                    pass = true;
                } else {
                    initMap(want, number);
                    pass = false;
                    break;
                }
            }
            if (pass) {
                initMap(want, number);
                answer++;
            }
        }
        return answer;
    }
    
    private void initMap(String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            bucket.put(want[i], number[i]);
        }
    }
}