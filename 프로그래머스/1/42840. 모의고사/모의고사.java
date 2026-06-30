import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i%a.length]) {
                answer1++;
            }
            if (answers[i] == b[i%b.length]) {
                answer2++;
            }
            if (answers[i] == c[i%c.length]) {
                answer3++;
            }
        }
        
        int max = Math.max(answer3, Math.max(answer1, answer2));
        List<Integer> list = new ArrayList<>();
        
        if (answer1 == max) {
            list.add(1);
        } 
        if (answer2 == max) {
            list.add(2);
        }
        if (answer3 == max) {
            list.add(3);
        }
        
        return list;
    }
}