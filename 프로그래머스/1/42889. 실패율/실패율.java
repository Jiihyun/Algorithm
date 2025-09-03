import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) { 
        int[] answer = new int[N];
        int[] count = new int[N + 1];
        Map<Integer, Double> map = new HashMap<>();
        int total = stages.length;

        for (int s : stages) {
            if (s <= N) {
                count[s]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (total == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) count[i] / total);
                total -= count[i];
            }
        }
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int cmp = Double.compare(b.getValue(), a.getValue());
            if (cmp == 0) {
                return Integer.compare(a.getKey(), b.getKey());
            }
            return cmp;
        });

        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}