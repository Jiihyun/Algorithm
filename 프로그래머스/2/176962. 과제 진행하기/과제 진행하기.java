import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<Subject> list = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            String start = plans[i][1];
            String playtime = plans[i][2];
            int time = changeToMin(start);
            list.add(new Subject(name, time, Integer.parseInt(playtime)));
        }
        list.sort((o1, o2) -> Integer.compare(o1.start, o2.start));
        
        Stack<Subject> st = new Stack<>();
        String[] answer = new String[list.size()];
        int index = 0;
        Subject nextSub;
        
        for (int i = 0; i < list.size() - 1; i++) {
            Subject current = list.get(i);
            Subject next = list.get(i + 1);

            int availableTime = next.start - current.start;

            if (current.playtime > availableTime) {
                current.playtime -= availableTime;
                st.push(current);
            } else {
                answer[index++] = current.name;
                int remainTime = availableTime - current.playtime;

                while (remainTime > 0 && !st.isEmpty()) {
                    Subject paused = st.pop();

                    if (paused.playtime <= remainTime) {
                        remainTime -= paused.playtime;
                        answer[index++] = paused.name;
                    } else {
                        paused.playtime -= remainTime;
                        st.push(paused);
                        remainTime = 0;
                    }
                }
            }
        }
        
        Subject last = list.get(list.size() - 1);
        answer[index++] = last.name;
        
        while (!st.isEmpty()) {
            answer[index++] = st.pop().name;
        }
        return answer;
    }
    
    private int changeToMin(String start) {
        int time = 0;
        String[] times = start.split(":");
        time += Integer.parseInt(times[0]) * 60;
        time += Integer.parseInt(times[1]);
        return time;
    }
    
    class Subject {
        String name;
        int start;
        int playtime;
        
        public Subject(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}
