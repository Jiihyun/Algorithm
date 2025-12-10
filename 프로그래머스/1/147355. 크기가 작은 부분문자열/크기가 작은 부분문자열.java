import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        Long pLong = Long.parseLong(p);
        List<Long> list = parseToLong(t, pLength);
        
        for (long num : list) {
            if (num <= pLong) {
                answer++;
            }
        }
        return answer;
    }
    
    public List<Long> parseToLong(String t, int pLength) {
        List<Long> list = new ArrayList<>();
        int startIndex = 0;
        while (startIndex <= t.length() - pLength) {
            int endIndex = startIndex + pLength;
            list.add(Long.parseLong(t.substring(startIndex, endIndex)));
            startIndex++;   
        }
        return list;
    }
}