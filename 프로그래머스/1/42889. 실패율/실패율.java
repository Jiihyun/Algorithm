import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        Map<Integer, Integer> failPplCount = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            failPplCount.put(i, 0);
        }

        for (int i = 0; i < stages.length; i++) {
            failPplCount.put(
                stages[i],
                failPplCount.getOrDefault(stages[i], 0) + 1
            );
        }

        int now = stages.length;
        double[] failPercent = new double[N];

        for (int i = 0; i < N; i++) {
            if (now == 0) {
                failPercent[i] = 0.0;
            } else {
                failPercent[i] =
                    (double) failPplCount.get(i + 1) / now;
            }
            now -= failPplCount.get(i + 1);
        }

        Map<Integer, Double> ans = new HashMap<>();
        for (int i = 0; i < N; i++) {
            ans.put(i + 1, failPercent[i]);
        }

        List<Map.Entry<Integer, Double>> list =
            new ArrayList<>(ans.entrySet());

        list.sort((a, b) -> {
            if (Double.compare(a.getValue(), b.getValue()) == 0) {
                return Integer.compare(a.getKey(), b.getKey());
            }

            return Double.compare(b.getValue(), a.getValue());
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}