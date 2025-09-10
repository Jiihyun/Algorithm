import java.util.*;

class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int count = getCount(binary);
        for (int i = n+1; i <= 1000000; i++) {
            String bi = Integer.toBinaryString(i);
            if (count == getCount(bi)) {
                return i;
            }
        }
        return -1;
    }
    private int getCount (String str) {
        int count = 0;
        
        for (char ch: str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }
}