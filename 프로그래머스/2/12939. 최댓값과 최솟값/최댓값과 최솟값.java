import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);

        }
        StringBuilder sb = new StringBuilder();
        sb.append(min)
            .append(" ")
            .append(max);
        return sb.toString();
    }
}