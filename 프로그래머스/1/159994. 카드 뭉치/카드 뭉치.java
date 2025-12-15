import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> q = new LinkedList<>();
        for (String g : goal) {
            q.add(g);
        }
        Queue<String> q1 = new LinkedList<>();
        for (String c1 : cards1) {
            q1.add(c1);
        }
        Queue<String> q2 = new LinkedList<>();
        for (String c2 : cards2) {
            q2.add(c2);
        }
        for (int i = 0; i < goal.length; i++) {
            if (!q1.isEmpty() && q1.peek().equals(q.peek())) {
                q1.poll();
                q.poll();
                continue;
            }
            if (!q2.isEmpty() && q2.peek().equals(q.peek())) {
                q2.poll();
                q.poll();
                continue;
            }
        }
        if (q.isEmpty()) {
            answer = "Yes";
        } else {
            answer = "No";
        }
        return answer;
    }
}