import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> sortedNums = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            String num = String.valueOf(numbers[i]);
            sortedNums.add(num);
        }
        String answer = "";
        
        sortedNums.sort((a, b) -> (b + a).compareTo(a + b));
        for (String num: sortedNums) {
            answer += num;
        }
        if (sortedNums.get(0).equals("0")) {
            return "0";
        }
        return answer;
    }
}
