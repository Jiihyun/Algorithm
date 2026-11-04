import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = normalize(m);

        String answer = "(None)"; // 일치하는 음악이 없을 때 반환할 값
        int maxPlayTime = -1;     // 가장 긴 재생 시간을 저장

        for (int i = 0; i < musicinfos.length; i++) {
            MusicInfos musicInfos = new MusicInfos(musicinfos[i]);
            int playTime = calPlayTime(musicInfos.startTime, musicInfos.endTime);

            // while문에서 playTime이 감소하므로 원래 재생 시간을 보관
            int originalPlayTime = playTime;

            StringBuilder sb = new StringBuilder();
            int index = 0;

            if (musicInfos.lylic.length() < playTime) {
                while (playTime > 0) {
                    if (index == musicInfos.lylic.length()) {
                        index = 0;
                    }
                    sb.append(musicInfos.lylic.charAt(index));
                    index++;
                    playTime--;
                }
            } else {
                while (playTime > 0) {
                    sb.append(musicInfos.lylic.charAt(index));
                    index++;
                    playTime--;
                }
            }

            String melody = sb.toString();

            // 멜로디가 일치하고, 기존 음악보다 재생 시간이 길 때만 갱신
            if (melody.contains(m) && originalPlayTime > maxPlayTime) {
                maxPlayTime = originalPlayTime; 
                answer = musicInfos.title;      
            }
        }

        return answer;
    }

    private int calPlayTime(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int startM = Integer.parseInt(start[0]) * 60
            + Integer.parseInt(start[1]);
        int endM = Integer.parseInt(end[0]) * 60
            + Integer.parseInt(end[1]);

        return endM - startM;
    }

    class MusicInfos {
        String startTime;
        String endTime;
        String title;
        String lylic;

        public MusicInfos(String musicinfos) {
            String[] str = musicinfos.split(",");
            this.startTime = str[0];
            this.endTime = str[1];
            this.title = str[2];
            this.lylic = normalize(str[3]);
        }
    }

    private String normalize(String melody) {
        return melody.replace("C#", "c")
                     .replace("D#", "d")
                     .replace("F#", "f")
                     .replace("G#", "g")
                     .replace("A#", "a");
    }
}