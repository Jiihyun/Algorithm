class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < timelogs.length; i++) {
            boolean pass = true;
            for (int j = 0; j < timelogs[i].length; j++) {
                int admit = toMinutes(schedules[i]) + 10;
                int dayOfWeek = (startday - 1 + j) % 7 + 1;
                if (dayOfWeek == 6 || dayOfWeek == 7) { // 토(6), 일(7) skip
                    continue;
                }

                if (toMinutes(timelogs[i][j]) > admit) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                answer++;
            }
        }
        return answer;
    }
    
      private int toMinutes(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return hour * 60 + minute;
    }
}
