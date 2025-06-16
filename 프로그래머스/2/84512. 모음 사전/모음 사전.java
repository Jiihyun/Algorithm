import java.util.*;

class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static List<String> dict = new ArrayList<>();
    
     public int solution(String word) {
         dfs("", 0);
         return dict.indexOf(word);
    }
    
    private void dfs(String now, int depth) {
        if (depth > 5) {
            return;
        }
        dict.add(now);
        for (char c: vowels) {
            dfs(now + c, depth + 1);
        }
    }
}