import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s','t','u','v','w','x','y','z'};
        List<Character> list = new ArrayList<>();
        for (char c : skip.toCharArray()) {
            list.add(c);
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            int cIndex = -1;
            for (int j = 0; j < alphabets.length; j++) {
                if (alphabets[j] == alpha) {
                    cIndex = j;
                    break;
                }
            }
            int count = 0;
            while (count < index) {
                cIndex = (cIndex + 1) % 26;  
                char nextAlpha = alphabets[cIndex];
                if (list.contains(nextAlpha)) {
                    continue;
                } else {
                    count++;
                }
            }
            sb.append(alphabets[cIndex]);
        }
        return sb.toString();
    }
}