import java.util.*;

class Solution {

    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>()); 

        for (int i = 1; i <= 8; i++) {
            Set<Integer> set = new HashSet<>();

            // 1. 5, 55, 555 같은 수 만들기
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            set.add(repeated);

            // 2. 이전 dp 조합
            for (int j = 1; j < i; j++) {
                Set<Integer> left = dp.get(j);
                Set<Integer> right = dp.get(i - j);

                for (int a : left) {
                    for (int b : right) {
                        set.add(a + b);
                        set.add(a - b);
                        set.add(a * b);
                        if (b != 0) {
                            set.add(a / b);
                        }
                    }
                }
            }
            dp.add(set);
            if (set.contains(number)) {
                return i;
            }
        }
        return -1;
    }
}