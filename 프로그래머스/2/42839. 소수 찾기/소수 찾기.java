import java.util.*;

class Solution {

    static boolean[] used;
    static Set<Integer> answer;

    public int solution(String numbers) {
        answer = new HashSet<>();
        used = new boolean[numbers.length()];

        String[] numberArr = numbers.split("");
        int[] nums = new int[numbers.length()];

        for (int i = 0; i < numberArr.length; i++) {
            nums[i] = Integer.parseInt(numberArr[i]);
        }

        dfs("", nums);
        return answer.size();
    }

    private void dfs(String current, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;

            String next = current + nums[i];
            int number = Integer.parseInt(next);

            if (isPrime(number)) {
                answer.add(number);
            }
            dfs(next, nums);
            used[i] = false;
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}