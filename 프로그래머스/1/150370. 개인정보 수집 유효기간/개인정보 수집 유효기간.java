import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<Character, Integer> map = new HashMap<>();
        for (String term : terms) {
            char type = term.charAt(0);
            int month = Integer.parseInt(term.substring(2));
            map.put(type, month);
        }
        
        List<Integer> list = new ArrayList<>();
        int todayDays = getDays(today);
        for (int i = 0; i < privacies.length; i++) {
		        String[] arr = privacies[i].split(" ");
		        int month = map.get(arr[1].charAt(0));
		        int privacyDays = getDays(arr[0]);
		        int actual = privacyDays + (28 * month - 1);
		        if (actual < todayDays) {
				        list.add(i+1);
		        }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int getDays(String date) {
		    String[] dateArr = date.split("\\.");
		    int year = Integer.parseInt(dateArr[0]);
		    int month = Integer.parseInt(dateArr[1]);
		    int day = Integer.parseInt(dateArr[2]);
		    return (year * 12 * 28) + (month * 28) + day;
    }
}
