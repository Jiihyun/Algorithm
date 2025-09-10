import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int[targets.length];
        
        for (int j = 0; j < targets.length; j++) {
            int sum = 0;
            String target = targets[j];
            boolean possible = true;
            
            for (int i = 0; i < target.length(); i++) {
                String alphabet = String.valueOf(target.charAt(i));
                int index = 101;
                
                for (String key: keymap) {
                    if (key.contains(alphabet)) {
                        index = Math.min(index,key.indexOf(alphabet)+1);
                    }
                }
                if (index == 101) {
                    possible = false;
                    sum = -1;
                    break;
                } else {
                    sum += index;
                }
            }
            answer[j] = sum;
        }
        return answer;
    }
}