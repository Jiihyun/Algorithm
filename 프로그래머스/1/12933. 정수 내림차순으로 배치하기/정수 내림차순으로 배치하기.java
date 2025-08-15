import java.util.*;

class Solution {
    public long solution(long n) {
        
        String numStr = String.valueOf(n);

        Character[] arr = new Character[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            arr[i] = numStr.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return Long.parseLong(sb.toString());
    }
}
