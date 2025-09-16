import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int i : lost) {
            lostSet.add(i);
        }
        for (int i : reserve) {
            reserveSet.add(i);
        }
        Set<Integer> intersection = new HashSet<>(lostSet);
        intersection.retainAll(reserveSet);
        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);
        
        for (int r: new TreeSet<>(reserveSet)) {
            if (lostSet.contains(r-1)) {
                lostSet.remove(r-1);
                continue;
            }
            if (lostSet.contains(r+1)) {
                lostSet.remove(r+1);
            }
        }
        return n - lostSet.size();
    }
}