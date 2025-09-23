import java.util.*;

class Solution {
    static Map<Character, Integer> map = new HashMap<>();

    public String solution(String[] survey, int[] choices) {        
        for (int i = 0; i < survey.length; i++) {
            String question = survey[i];
            int answer = choices[i];
            if (answer < 4) {
                map.put(question.charAt(0), map.getOrDefault(question.charAt(0), 0) + (4 - answer));
            } else if (answer > 4) {
                map.put(question.charAt(1), map.getOrDefault(question.charAt(1), 0) + (answer - 4));
            }
        }
        String first = getType('R', 'T');
        String second = getType('C', 'F');
        String third = getType('J', 'M');
        String fourth = getType('A', 'N');
        return first+second+third+fourth;
    }
    
    private String getType(char type1, char type2) {
        int score1 = map.getOrDefault(type1, 0);
        int score2 = map.getOrDefault(type2, 0);
        
        if (score1 >= score2) {
            return String.valueOf(type1);
        } 
        return String.valueOf(type2);
    }
}