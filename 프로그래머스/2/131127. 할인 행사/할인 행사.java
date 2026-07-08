import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                items.add(want[i]);
            }
        }
        
        int count = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            List<String> currentItems = new ArrayList<>(items);
            for (int j = i; j < i + 10; j++) {
                if (currentItems.contains(discount[j])) {
                    currentItems.remove(discount[j]);
                }
            }
            if (currentItems.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}

// 이게 완탐이 가능한 건가?? 모르게씀 100000개가 있고 원하는 건 10개인데 시간 복잡도 계ㅅ산을 어케 함?