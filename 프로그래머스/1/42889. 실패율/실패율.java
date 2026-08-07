import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        int[] failPpl = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            int count = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    count++;
                }
            }
            failPpl[i] = count;
        }
        
        double[] failRate = new double[N+1];
        int totalPpl = stages.length;
        for (int i = 1; i <= N; i++) {
            if (totalPpl == 0) {
                failRate[i] = 0;
            } else {
                failRate[i] = (double) failPpl[i] / totalPpl;
            }
            totalPpl -= failPpl[i];
        }
        
        List<Stage> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(new Stage(i, failRate[i]));
        }
        
        list.sort((a,b) -> {
            if (a.rate == b.rate) {
                return a.num - b.num;
            }
            return Double.compare(b.rate, a.rate);
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).num;
        }
        return answer;
    }
    
    class Stage {
        int num;
        double rate;

        Stage(int num, double rate) {
            this.num = num;
            this.rate = rate;
        }
    }
}
