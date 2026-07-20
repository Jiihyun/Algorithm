import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String word = str1.substring(i, i+2).toLowerCase();
            if ('a' <= word.charAt(0)
               && word.charAt(0) <= 'z'
               && 'a' <= word.charAt(1)
               && word.charAt(1) <= 'z') {
                a.add(word);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String word = str2.substring(i, i+2).toLowerCase();
            if ('a' <= word.charAt(0)
               && word.charAt(0) <= 'z'
               && 'a' <= word.charAt(1)
               && word.charAt(1) <= 'z') {
                b.add(word);
            }
        }
        Map<String, Integer> aMap = new HashMap<>();
        Map<String, Integer> bMap = new HashMap<>();
        
        for (int i = 0; i < a.size(); i++) {
            String s = a.get(i);
            aMap.put(s, aMap.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < b.size(); i++) {
            String s = b.get(i);
            bMap.put(s, bMap.getOrDefault(s, 0) + 1);
        }
        Set<String> keys = new HashSet<>();
        keys.addAll(aMap.keySet());
        keys.addAll(bMap.keySet());
        int intersection = 0;
        int union = 0;
        for (String key : keys) {
            int cntA = aMap.getOrDefault(key, 0);
            int cntB = bMap.getOrDefault(key, 0);
            
            intersection += Math.min(cntA, cntB);
            union += Math.max(cntA, cntB);
        }
        System.out.println(intersection + " " + union);
        if (union == 0) {
            return 65536;
        }
        return (int) ((double) intersection / union * 65536);
    }
}

// 영문자로 된 글자 쌍만 유효
// 1. substring으로 2글자씩 자르고, lowercase해서 다 영어인지 판단