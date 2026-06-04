import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) { 
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int i = 0; i < reserve.length; i++) {
            reserveSet.add(reserve[i]);
        }
        for (int i = 0; i < lost.length; i++) {
            lostSet.add(lost[i]);
        }
        
        Set<Integer> overlap = new HashSet<>(lostSet);
        overlap.retainAll(reserveSet);
        for (Integer num : overlap) {
            lostSet.remove(num);
            reserveSet.remove(num);
        }
        
        for (Integer num : reserveSet) {
            if (lostSet.contains(num - 1)) {
                lostSet.remove(num - 1);
            } else if (lostSet.contains(num + 1)) {
                lostSet.remove(num + 1);
            }
        }
        
        return n - lostSet.size();
    }
}