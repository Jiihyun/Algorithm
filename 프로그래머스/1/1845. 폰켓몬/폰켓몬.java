import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int half = nums.length / 2;
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i = 0; i <nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        int distinct = m.keySet().size();
        if (distinct >= half) {
            return half;
        } 
            return distinct;
    }
}