import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)
               || set.contains(words[i])) {
                int ppl = (i % n) + 1;
                int round = (i / n) + 1;
                return new int[]{ppl, round};
            } else {
                set.add(words[i]);
            }
        }
        return new int[]{0,0};
    }
}