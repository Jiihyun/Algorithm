import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] monthDays = {0,31,29,31,30,31,30,31,31,30,31,30,31}; 

        int totalDays = 0;
        for (int i = 1; i < a; i++) {
            totalDays += monthDays[i];
        }
        totalDays += (b - 1);

        int index = (5 + totalDays) % 7; 
        return day[index];
    }
}
