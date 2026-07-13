import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        String[] arr = s.substring(2, s.length() - 2).split("\\},\\{");

        for (String st : arr) {
            String[] nums = st.split(",");
            int[] num = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                num[i] = Integer.parseInt(nums[i]);
            }

            list.add(num);
        }

        list.sort(Comparator.comparingInt(num -> num.length));

        int[] answer = new int[list.size()];
        int idx = 0;

        for (int[] nums : list) {
            for (int n : nums) {
                if (set.add(n)) {   
                    answer[idx++] = n;
                }
            }
        }

        return answer;
    }
}