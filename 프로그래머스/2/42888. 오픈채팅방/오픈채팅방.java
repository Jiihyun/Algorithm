import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        Map<String, String> info = new HashMap<>();
        
        for (String line: record) {
            String[] sp = line.split(" ");
            String keyword = sp[0];
            String userId = sp[1];
            
            if ("Enter".equals(keyword) || "Change".equals(keyword)) {
                String nickname = sp[2];
                info.put(userId, nickname);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (String line: record) {
            String[] sp = line.split(" ");
            String keyword = sp[0];
            String userId = sp[1];
            
            if ("Enter".equals(keyword)) {
                answer.add(info.get(userId) + "님이 들어왔습니다.");
            }
            if ("Leave".equals(keyword)) {
                answer.add(info.get(userId) + "님이 나갔습니다.");
            }
        }
        return answer;
    }
}