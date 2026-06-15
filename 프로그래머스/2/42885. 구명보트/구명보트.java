import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int start = 0;
        int last = people.length - 1;
        
        while (start <= last) {
            if (people[start] + people[last] <= limit) {
                count++;
                last--;
                start++;
            } else {
                count++;
                last--;
            }
        }
        return count;
    }
}
