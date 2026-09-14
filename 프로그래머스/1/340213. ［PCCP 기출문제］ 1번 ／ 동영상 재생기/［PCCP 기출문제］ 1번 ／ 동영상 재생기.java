import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int time = parseTime(pos);
        int videoLen = parseTime(video_len);
        int opStart = parseTime(op_start);
        int opEnd = parseTime(op_end);
        
        for (int i = 0; i < commands.length; i++) {
            if (time >= opStart && time <= opEnd) {
                time = opEnd;
            }
            if (commands[i].equals("prev")) {
                time -= 10;
                if (time < 0) {
                    time = 0;
                }
            }
            if (commands[i].equals("next")) {
                time += 10;
                if (time > videoLen) {
                    time = videoLen;
                }
            }
            if (time >= opStart && time <= opEnd) {
                time = opEnd;
            }
        }
        
        String min = String.valueOf(time / 60);
        if (min.length() == 1) {
            min = "0" + min;
        }
        String second = String.valueOf(time % 60);
        if (second.length() == 1) {
            second = "0" + second;
        }
        return min + ":" + second;
    }
    
    private int parseTime(String timeStr) {
        String[] nums = timeStr.split(":");
        return Integer.parseInt(nums[0]) * 60 + Integer.parseInt(nums[1]);
    }
}
// 0 -> 59
// 10초 전 이동 "prev", 10초 미만일 경우에는 처음으로 0분 0초
// 10초 후 이동 "next", 10초 미만 -> 영상 마지막 위치
// 오프닝 건너뛰기 op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치