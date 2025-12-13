import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int start = 0;
        while (start < numbers.length - 1) {
            for (int i = start + 1; i < numbers.length; i++) {
                set.add(numbers[start] + numbers[i]);
            }
            start++;
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}