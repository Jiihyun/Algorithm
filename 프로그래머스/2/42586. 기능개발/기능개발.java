import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
         int[] days = new int[progresses.length];
        for (int i = 0; i<progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                days[i] = (100 - progresses[i]) / speeds[i];
            } else {
                days[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }
        int now = days[0];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < days.length; i++) {
            if (now < days[i]) {
                now = days[i];
                list.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for (int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}