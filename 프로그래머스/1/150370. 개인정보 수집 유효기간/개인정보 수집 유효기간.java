import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<Character, Integer> map = new HashMap<>();
        for (String term : terms) {
            char type = term.charAt(0);
            int month = Integer.parseInt(term.substring(2));
            map.put(type, month);
        }
        
        int todayDays = convertDateToDays(today);
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            String startDate = arr[0];
            char type = arr[1].charAt(0);
            
            int termMonth = map.get(type);
            int startDays = convertDateToDays(startDate);
            int expireDays = startDays + termMonth * 28 - 1;
            
            if (expireDays < todayDays) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int convertDateToDays(String date) {
        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(5, 7));
        int d = Integer.parseInt(date.substring(8, 10));
        return (y * 12 * 28) + (m * 28) + d;
    }
}
