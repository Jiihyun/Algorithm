import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
             Map<String, Integer> currentWants = new HashMap<>(wants);
            for (int j = i; j <  i + 10; j++) {
                if (currentWants.containsKey(discount[j])
                   && currentWants.get(discount[j]) > 0) {
                    currentWants.put(discount[j], currentWants.get(discount[j]) - 1);
                    // System.out.println(discount[j]);
                    // System.out.println(wants.get(discount[j]));
                } else {
                    break;
                }
            }
            int sum = 0;
            for (int value : currentWants.values()) {
                sum += value;
            }
            if (sum == 0) {
                answer++;
            }
        }
        return answer;
    }
}

// 매일 한 가지 제품 할인, 할인하는 제품은 하루에 하나씩만 구매 가능
// 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우, 회원가입