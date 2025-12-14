import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list, Collections.reverseOrder());
            
            if (list.size() > k) {
                list.remove(list.size() - 1);
            }
            answer[i] = list.get(list.size() - 1);
        }
        return answer;
    }
}