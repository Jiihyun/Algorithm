import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String word = str1.substring(i, i+2).toLowerCase();
            if ('a' <= word.charAt(0) && word.charAt(0) <= 'z'
               && 'a' <= word.charAt(1) && word.charAt(1) <= 'z') {
                a.put(word, a.getOrDefault(word, 0) + 1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String word = str2.substring(i, i+2).toLowerCase();
            if ('a' <= word.charAt(0) && word.charAt(0) <= 'z'
               && 'a' <= word.charAt(1) && word.charAt(1) <= 'z') {
                b.put(word, b.getOrDefault(word, 0) + 1);
            }
        }
        
        Set<String> words = new HashSet<>();
        words.addAll(a.keySet());
        words.addAll(b.keySet());
        
        int inter = 0;
        int union = 0;
        
        for (String word: words) {
            int cntA = a.getOrDefault(word, 0);
            int cntB = b.getOrDefault(word, 0);
            
            inter += Math.min(cntA, cntB);
            union += Math.max(cntA, cntB);
        }
        if (union == 0) {
            return 65536;
        }
        return (int) ((double) inter / union * 65536);
        }
}