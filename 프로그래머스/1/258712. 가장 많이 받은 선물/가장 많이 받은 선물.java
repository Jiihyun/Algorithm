import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> pplIndex = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            pplIndex.put(friends[i], i);
        }
        
        int[][] presents = new int[friends.length][friends.length];
        for (int i = 0; i < gifts.length; i++) {
            String[] ppl = gifts[i].split(" ");
            int giveIndex = pplIndex.get(ppl[0]);
            int takeIndex = pplIndex.get(ppl[1]);
            presents[giveIndex][takeIndex] += 1;
        }
        
        int[] gift = new int[friends.length];
        for (int i = 0; i < presents.length; i++) {
            int give = 0;
            int take = 0;
            for (int j = 0; j < presents.length; j++) {
                give += presents[i][j];
                take += presents[j][i];
            }
            gift[i] = give - take;
        }
        
        int[] answer = new int[friends.length];
        for (int i = 0; i < presents.length; i++) {
            for (int j = i + 1; j < presents.length; j++) {
                if (presents[i][j] > presents[j][i]) {
                    answer[i] += 1;
                }
                if (presents[i][j] < presents[j][i]) {
                    answer[j] += 1;
                }
                
                if (presents[i][j] == presents[j][i]) {
                    if (gift[i] > gift[j]) {
                        answer[i] += 1;
                    }
                     if (gift[i] < gift[j]) {
                        answer[j] += 1;
                    }
                }
            }
        }
        
        int max = 0;
        for (int i: answer) {
            max = Math.max(max, i);
        }
        return max;
    }
}