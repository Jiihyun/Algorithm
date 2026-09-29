import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] sorted = new int[book_time.length][2];
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        
        for (int i = 0; i < book_time.length; i++) {
            int startTime = parseStartTime(book_time[i][0]);
            int endTime = parseEndTime(book_time[i][1]);
            sorted[i][0] = startTime;
            sorted[i][1] = endTime;
        }
        
        Arrays.sort(sorted, (o1, o2) -> Integer.compare(o1[0],o2[0]));

        for (int i = 0; i < sorted.length; i++) {
            if (!endTimes.isEmpty() && sorted[i][0] >= endTimes.peek()) {
                   endTimes.poll();
                }
            endTimes.offer(sorted[i][1]);
        }
        return endTimes.size();
    }
    
    private int parseStartTime(String time) {
        String[] hm = time.split(":");
        int min = Integer.parseInt(hm[0]) * 60;
        return min + Integer.parseInt(hm[1]);
    }
    
    private int parseEndTime(String time) {
        String[] hm = time.split(":");
        int min = Integer.parseInt(hm[0]) * 60;
        return min + Integer.parseInt(hm[1]) + 10;
    }
}