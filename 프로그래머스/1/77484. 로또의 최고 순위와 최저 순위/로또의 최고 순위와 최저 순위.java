import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        List<Integer> winNums = new ArrayList<>();
        
        for (int num : win_nums) {
            winNums.add(num);
        }

        int count = 0;
        int zero = 0;
        for (int num: lottos) {
            if (winNums.contains(num)) {
                count++;
            }
            if (num == 0) {
                zero++;
            }
        }
        int[] answer = new int[2];
        answer[1] = getRank(count);
        answer[0] = getRank(count+zero);
        return answer;
    }
    
    private int getRank (int num) {
        if (num == 6) {
            return 1;
        }
        if (num == 5) {
            return 2;
        }
        if (num == 4) {
            return 3;
        }
        if (num == 3) {
            return 4;
        }
        if (num == 2) {
            return 5;
        }
        return 6;
    }
}